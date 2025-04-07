document.addEventListener('DOMContentLoaded', function () {
  const userForm = document.getElementById('gradeForm');
  const popupModal = document.getElementById('addGrade');

  if (!userForm || !popupModal) {
    console.error('Не удалось найти один из необходимых элементов');
    return;
  }

  userForm.addEventListener('submit', async function (e) {
    e.preventDefault();

    const formData = new FormData(this);

    if (!formData.get('grade') || !formData.get('date')) {
      alert('Заполните обязательные поля!');
      return;
    }

    try {
      const response = await fetch('/dairy-project/teacher/grades/add', {
        method: 'POST',
        body: formData
      });

      if (!response.ok) {
        const errorData = await response.json();
        throw new Error(
            errorData.message || `Ошибка сервера: ${response.status}`);
      }

      alert('Отметка добавлена успешно!');
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