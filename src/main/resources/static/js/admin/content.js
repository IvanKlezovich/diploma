document.addEventListener('DOMContentLoaded', function () {
  const userForm = document.getElementById('lessonForm');
  const popupModal = document.getElementById('addLesson');

  if (!userForm || !popupModal) {
    console.error('Не удалось найти один из необходимых элементов');
    return;
  }

  userForm.addEventListener('submit', async function (e) {
    e.preventDefault();

    const formData = new FormData(this);

    if (!formData.get('lessonName') || !formData.get('lessonDescription')) {
      alert('Заполните обязательные поля!');
      return;
    }

    try {
      const response = await fetch('/dairy-project/admin/lessons/add', {
        method: 'POST',
        body:  formData
      });

      if (!response.ok) {
        const errorData = await response.json();
        throw new Error(
            errorData.message || `Ошибка сервера: ${response.status}`);
      }

      alert('Предмет добавлен успешно!');
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
