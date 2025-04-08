document.addEventListener('DOMContentLoaded', function () {
  const userForm = document.getElementById('gradeForm');
  const popupModal = document.getElementById('addGrade');

  // Получаем элемент даты
  const dateInput = document.getElementById('date');

  // Устанавливаем текущую дату при загрузке
  function setDate() {
    const today = new Date();
    const year = today.getFullYear();
    const month = String(today.getMonth() + 1).padStart(2, '0');
    const day = String(today.getDate()).padStart(2, '0');
    dateInput.value = `${year}-${month}-${day}`;
  }

  // Устанавливаем текущую дату при первом открытии
  setDate();

  // Обновляем дату при каждом открытии модального окна
  const modal = document.getElementById('addGrade');
  modal.addEventListener('show.bs.modal', setDate);

  if (!userForm || !popupModal) {
    console.error('Не удалось найти один из необходимых элементов');
    return;
  }

  userForm.addEventListener('submit', async function (e) {
    e.preventDefault();

    const formData = new FormData(this);

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