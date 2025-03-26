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
  console.log(lessons);
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
      const classes = await fetchClasses();
      const lessons = await fetchLessons();

      console.log(classes, lessons)
      await updateLessonsSelector(lessons);
      await updateClassesSelector(classes);
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
          lessonId: formData.get('lesson'),
          classId: formData.get('class'),
          apartment: formData.get('apartment'),
          startTime: formData.get('lesson-time-begin'),
          endTime: formData.get('lesson-time-end'),
          dayOfWeek: formData.get('days')
        })
      });

      if (!response.ok) {
        const errorData = await response.json();
        throw new Error(
            errorData.message || `Ошибка сервера: ${response.status}`);
      }

      const modal = bootstrap.Modal.getInstance(schedulerModal);
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

document.addEventListener('DOMContentLoaded', function() {
  const classSelector = document.getElementById('classSelect');
  const loader = document.getElementById('loader');

  // Функция для получения списка классов
  async function fetchClasses() {
    try {
      const response = await fetch('/api/classes');
      const classes = await response.json();

      // Очистить существующие опции
      classSelector.innerHTML = '<option value="all">Все классы</option>';

      // Добавить новые опции
      classes.forEach(cls => {
        const option = document.createElement('option');
        option.value = cls.id;
        option.textContent = cls.name;
        classSelector.appendChild(option);
      });

      // Спрятать лоадер после загрузки данных
      loader.classList.add('hidden');

    } catch (error) {
      console.error('Ошибка при получении списка классов:', error);
      loader.classList.add('hidden');
    }
  }

  // Функция для фильтрации расписания
  function filterSchedule(selectedClassId) {
    const scheduleEntries = document.querySelectorAll('.class-schedule .diary-entry');

    scheduleEntries.forEach(entry => {
      const className = entry.closest('.class-schedule').querySelector('h2').textContent;
      if (selectedClassId === 'all' || className === selectedClassId) {
        entry.style.display = 'block';
      } else {
        entry.style.display = 'none';
      }
    });
  }

  // Загрузить список классов при загрузке страницы
  fetchClasses();

  // Обработчик изменения выбора класса
  classSelector.addEventListener('change', function(e) {
    filterSchedule(e.target.value);
  });
});
