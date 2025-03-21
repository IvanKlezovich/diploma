async function fetchClasses() {
  try {
    const response = await fetch('/dairy-project/admin/classes/list');
    if (!response.ok) {
      throw new Error(
          `Ошибка при получении списка классов: ${response.status}`);
    }

    return await response.json();
  } catch (error) {
    console.error('Ошибка при получении списка классов:', error);
    showAlert('Ошибка при загрузке списка классов. Попробуйте позже.');
  }
}

async function fetchLessons() {
  try {
    const response = await fetch('/dairy-project/admin/lesson/list');

    if (!response.ok) {
      throw new Error(
          `Ошибка при получении списка классов: ${response.status}`);
    }

    return await response.json();
  } catch (error) {
    console.error('Ошибка при получении списка классов:', error);
    showAlert('Ошибка при загрузке списка классов. Попробуйте позже.');
  }
}

async function updateClassesSelector(forms) {
  const formSelector = document.getElementById("class-name");
  if (!formSelector) {
    console.error('Не удалось найти один из необходимых элементов');
    return;
  }
  console.log(forms)
  const classesSelect = document.getElementById('class-name');
  classesSelect.innerHTML = '<option value="">Выберите класс</option>';
  forms.forEach(form => {
    const option = document.createElement('option');
    option.value = form.classId;
    option.textContent = `${form.classname}`;
    classesSelect.appendChild(option);
  })
}

async function updateLessonsSelector(lessons) {
  const lessonSelector = document.getElementById("selector-lesson");
  if (!lessonSelector) {
    console.error('Не удалось найти один из необходимых элементов');
    return;
  }
  const lessonsSelect = document.getElementById('selector-lesson');
  lessonsSelect.innerHTML = '<option value="">Выберите урок</option>';
  lessons.forEach(lesson => {
    const option = document.createElement('option');
    option.value = lesson.lessonId;
    option.textContent = `${lesson.lessonName}`;
    lessonsSelect.appendChild(option);
  })
}

document.getElementById('addLessonToScheduler').addEventListener(
    'show.bs.modal', async function () {
      const classes = fetchClasses();
      const lessons = fetchLessons();

      await updateClassesSelector(classes);
      await updateLessonsSelector(lessons);
    })

document.addEventListener('DOMContentLoaded', function () {
  const addSchedulerForm = document.getElementById('addLessonToSchedulerForm');
  const schedulerModal = document.getElementById('addLessonToScheduler');

  if (!addSchedulerForm || !schedulerModal) {
    console.error('Не удалось найти один из необходимых элементов');
    return;
  }

  addSchedulerForm.addEventListener('submit', async function (e) {
    e.preventDefault();

    const formData = new FormData(this);

    // if (!formData.get('class-name') || !formData.get('lesson-name')
    //     || !formData.get('apartment') || !formData.get('lesson-time-begin')
    //     || !formData.get('lesson-time-end')) {
    //   alert('Заполните все обязательные поля!');
    //   return;
    // }

    try {
      const response = await fetch('/dairy-project/admin/scheduler/add', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({
          classname: formData.get('classname'),
          teacherId: formData.get('teacher')
        })
      });

      if (!response.ok) {
        const errorData = await response.json();
        throw new Error(
            errorData.message || `Ошибка сервера: ${response.status}`);
      }

      const modal = bootstrap.Modal.getInstance(classModal);
      modal.hide();
      alert('Расписание успешно создано!');
      location.reload();

    } catch (error) {
      console.error('Ошибка при создании расписания:', error);
      alert(`Произошла ошибка при создании расписания: ${error.message}`);
      location.reload();
    }
  });
});