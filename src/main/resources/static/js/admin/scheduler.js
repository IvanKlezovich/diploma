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

async function updateClassesSelectorFromFile(forms) {
  console.log(forms)
  const classesSelect = document.getElementById('class-name-file');
  classesSelect.innerHTML = '<option value="">Выберите класс</option><option value="all">Все классы</option>';
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

async function updateSchedule(classId) {
  try {
    const response = await fetch(`/dairy-project/admin/scheduler/${classId}`);
    if (!response.ok) {
      throw new Error(`Ошибка при получении расписания: ${response.status}`);
    }
    const scheduleData = await response.json();

    // Очищаем текущее расписание
    const scheduleContainer = document.querySelector('.schedule-container');
    scheduleContainer.innerHTML = '';

    // Создаем новое расписание
    scheduleData.days.forEach(day => {
      const weekHalf = document.createElement('div');
      weekHalf.className = 'week-half';

      day.periods.forEach(period => {
        const lessonElement = createLessonElement(period);
        weekHalf.appendChild(lessonElement);
      });

      scheduleContainer.appendChild(weekHalf);
    });
  } catch (error) {
    console.error('Ошибка при обновлении расписания:', error);
    showAlert('Произошла ошибка при обновлении расписания');
  }
}

async function createLessonElement(lesson) {
  const lessonDiv = document.createElement('div');
  lessonDiv.className = 'diary-entry';

  lessonDiv.innerHTML = `
    <div class="lesson-info"><h4>${lesson.subject}</h4></div>
    <div class="lesson-details">
      <p class="lesson-time">${lesson.startTime} - ${lesson.endTime}</p>
      <p>Кабинет: ${lesson.room}</p>
    </div>
    <div class="actions">
      <button class="btn-block btn-secondary">Редактировать</button>
      <button class="btn-edit">Изменить</button>
      <button class="btn-delete">Удалить</button>
    </div>
  `;

  return lessonDiv;
}

document.getElementById('classSelect').addEventListener(
    'change', async function (e) {
      const selectedClass = e.target.value;
      try {
        if (selectedClass === 'all') {
          document.querySelectorAll('.class-schedule').forEach(schedule => {
            schedule.style.display = 'block';
          });
          return;
        }

        document.querySelectorAll('.class-schedule').forEach(schedule => {
          schedule.style.display = 'none';
        });

        const selectedSchedule = document.querySelector(
            `.class-schedule[data-class="${selectedClass}"]`);
        if (selectedSchedule) {
          selectedSchedule.style.display = 'block';
        }
      } catch (error) {
        console.error('Ошибка при фильтрации расписания:', error);
        showAlert('Произошла ошибка при фильтрации расписания');
      }
    });

document.getElementById('addLessonToScheduler').addEventListener(
    'show.bs.modal', async function () {
      const classes = await fetchClasses();
      const lessons = await fetchLessons();

      console.log(classes, lessons)
      await updateLessonsSelector(lessons);
      await updateClassesSelector(classes);
    })

document.getElementById('addLessonToSchedulerByFile').addEventListener(
    'show.bs.modal', async function () {
      const classes = await fetchClasses();

      await updateClassesSelectorFromFile(classes);
    }
)

document.addEventListener(
    'DOMContentLoaded', async function () {
      const addSchedulerForm = document.getElementById(
          'addLessonToSchedulerForm');
      const addSchedulerFormFromFile = document.getElementById(
          'addLessonToSchedulerByFileForm');
      const schedulerModal = document.getElementById(
          'addLessonToScheduler');
      const addSchedulerModalFromFile = document.getElementById(
          'addLessonToSchedulerByFile');
      const selectedClass = document.getElementById('classSelect').value;

      if (!addSchedulerForm || !schedulerModal) {
        console.error('Не удалось найти один из необходимых элементов');
        return;
      }
      addSchedulerFormFromFile.addEventListener('submit', async function (e) {
        e.preventDefault();

        const formData = new FormData(this);
        const progressBar = document.getElementById('uploadProgress');
        const xhr = new XMLHttpRequest();

        xhr.upload.addEventListener('progress', function (e) {
          if (e.lengthComputable) {
            const percentComplete = Math.round((e.loaded / e.total) * 100);
            progressBar.style.width = percentComplete + '%';
            progressBar.setAttribute('aria-valuenow', percentComplete);
          }
        });

        xhr.addEventListener('load', function () {
          if (xhr.status === 200) {
            alert('Расписание успешно загружено!');
            progressBar.style.width = '0%';
          } else {
            alert('Ошибка при загрузке расписания: ' + xhr.statusText);
          }
        });

        xhr.open('POST', '/dairy-project/admin/scheduler/add/file', true);
        xhr.send(formData);

        const modal = bootstrap.Modal.getInstance(addSchedulerModalFromFile);
        modal.hide();
        alert('Расписание успешно создано!');
        location.reload();
      });

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