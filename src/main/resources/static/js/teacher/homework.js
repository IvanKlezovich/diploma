document.addEventListener('DOMContentLoaded', function () {
  const userForm = document.getElementById('homeworkForm');
  const popupModal = document.getElementById('addModal');

  if (!userForm || !popupModal) {
    console.error('Не удалось найти один из необходимых элементов');
    return;
  }

  userForm.addEventListener('submit', async function (e) {
    e.preventDefault();

    const formData = new FormData(this);

    if (!formData.get('login') || !formData.get('email') || !formData.get(
        'firstname')) {
      alert('Заполните обязательные поля!');
      return;
    }

    try {
      const response = await fetch('/dairy-project/teacher/homework/add', {
        method: 'POST',
        body: formData
      });

      if (!response.ok) {
        const errorData = await response.json();
        throw new Error(
            errorData.message || `Ошибка сервера: ${response.status}`);
      }

      alert('Пользователь добавлен успешно!');
      this.reset();

      // Используем Bootstrap методы для работы с модальным окном
      const modal = bootstrap.Modal.getInstance(popupModal);
      modal.hide();

    } catch (error) {
      console.error('Ошибка:', error);
      alert('Произошла ошибка при отправке данных: ' + error.message);
    }
  });
});
document.querySelectorAll('.btn-block.btn-secondary').forEach(button => {
  button.addEventListener('click', function (e) {
    e.preventDefault();

    const userId = this.closest('tr').querySelector(
        'td:first-child').textContent;

    fetch('/dairy-project/admin/users/block', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: {userId: userId}
    })
    .then(response => response.json())
    .then(data => {
      if (data.success) {
        const statusCell = this.closest('tr').querySelector('td:nth-child(4)');
        statusCell.textContent = 'Заблокирован';
        this.textContent = 'Разблокировать';
        this.classList.remove('btn-secondary');
        this.classList.add('btn-danger');
      } else {
        alert('Ошибка при блокировке пользователя: ' + data.message);
      }
    })
    .catch(error => {
      alert('Произошла ошибка при отправке данных: ' + error.message);
    });
  });
});