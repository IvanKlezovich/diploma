document.addEventListener('DOMContentLoaded', function () {
  const userForm = document.getElementById('userForm');
  const popupModal = document.getElementById('popupModal'); // Без # в идентификаторе

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
      const response = await fetch('/dairy-project/admin/users/add', {
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
    location.reload();
  });
});

document.querySelectorAll('.btn-block.btn-secondary').forEach(button => {
  button.addEventListener('click', async function (e) {
    e.preventDefault();

    const userId = this.closest('tr').querySelector(
        'td:first-child').textContent;

    try {
      const response = await fetch('/dairy-project/admin/users/block', {
        method: 'PATCH',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({userId: userId})
      });

      // Добавляем отладочную информацию
      console.log('Ответ сервера:', {
        status: response.status,
        ok: response.ok,
        headers: Object.fromEntries(response.headers.entries())
      });

      if (!response.ok) {
        const errorData = await response.json();
        console.log('Ошибка сервера:', errorData);
        throw new Error(
            errorData.message || `Ошибка сервера: ${response.status}`);
      }

    } catch (error) {
      console.error('Ошибка при блокировке пользователя:', error);
      alert(`Произошла ошибка при блокировке пользователя: ${error.message}`);
    }
    location.reload();
  });
});
document.querySelectorAll('.btn-edit').forEach(button => {
  button.addEventListener('click', async function (e) {
    e.preventDefault();

    // Получаем данные пользователя из строки таблицы
    const row = this.closest('tr');
    const userId = row.cells[0].textContent;
    const currentRole = row.cells[3].textContent;

    // Находим и заполняем модальное окно
    const editModal = document.getElementById('editModal');
    const roleSelect = editModal.querySelector('#role-type');

    // Выбираем текущую роль в селекте
    roleSelect.value = currentRole;

    // Показываем модальное окно
    const modal = new bootstrap.Modal(editModal);
    modal.show();

    // Обработка формы изменения роли
    const roleForm = document.getElementById('roleForm');
    roleForm.addEventListener('submit', async function (e) {
      e.preventDefault();

      try {
        const newRole = roleSelect.value;

        // Отправляем запрос на изменение роли
        const response = await fetch(
            `/dairy-project/admin/users/${userId}/role`, {
              method: 'PATCH',
              headers: {
                'Content-Type': 'application/json'
              },
              body: JSON.stringify({role: newRole})
            });

        if (!response.ok) {
          const errorData = await response.json();
          throw new Error(
              errorData.message || `Ошибка сервера: ${response.status}`);
        }

        modal.hide();

        alert('Роль успешно изменена!');

      } catch (error) {
        console.error('Ошибка при изменении роли:', error);
        alert(`Произошла ошибка при изменении роли: ${error.message}`);
      }
      location.reload();
    });
  });
});

async function deleteUser() {
  // Показываем диалог подтверждения
  if (!confirm('Вы уверены, что хотите удалить этого пользователя?')) {
    return;
  }

  try {
    // Получаем ID пользователя из таблицы
    const row = document.querySelector('.btn-delete').closest('tr');
    const userId = row.cells[0].textContent === 'Иванов Иван' ? 'user1'
        : 'user2';

    // Отправляем DELETE-запрос на сервер
    const response = await fetch(`/api/users/${userId}`, {
      method: 'DELETE',
      headers: {
        'Content-Type': 'application/json',
      }
    });

    if (!response.ok) {
      throw new Error(`Ошибка при удалении пользователя: ${response.status}`);
    }

    const result = await response.json();
    console.log('Пользователь успешно удален:', result);

    // Обновляем таблицу
    updateTable(result);

  } catch (error) {
    console.error('Ошибка:', error);
    alert('Произошла ошибка при удалении пользователя');
  }
}