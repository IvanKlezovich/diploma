async function fetchClasses() {
  try {
    const response = await fetch('/dairy-project/admin/classes/list');
    if (!response.ok) {
      throw new Error(
          `Ошибка при получении списка учеников: ${response.status}`);
    }
    return await response.json();
  } catch (error) {
    console.error('Ошибка при получении списка учеников:', error);
    return [];
  }
}

async function fetchStudents() {
  try {
    const response = await fetch('/dairy-project/admin/student/list');
    if (!response.ok) {
      throw new Error(
          `Ошибка при получении списка учеников: ${response.status}`);
    }
    return await response.json();
  } catch (error) {
    console.error('Ошибка при получении списка учеников:', error);
    return [];
  }
}

async function fetchTeachers() {
  try {
    const response = await fetch('/dairy-project/admin/teachers/list');
    if (!response.ok) {
      throw new Error(
          `Ошибка при получении списка учителей: ${response.status}`);
    }
    return await response.json();
  } catch (error) {
    console.error('Ошибка при получении списка учителей:', error);
    return [];
  }
}

async function fetchStudentToClass(formId) {
  try {
    const responce = await fetch(`/dairy-project/admin/class/${formId}/list`);
    if (!responce.ok) {
      throw new Error(
          `Ошибка при получении списка учеников: ${response.status}`);
    }
    return await responce.json();
  } catch (error) {
    console.error('', error);
    return [];
  }
}

async function updateClassesSelect(classes) {
  const classSelect = document.getElementById('student-class');
  classSelect.innerHTML = '<option value="">Выберите Класс</option>';
  classes.forEach(clas => {
    const option = document.createElement('option');
    option.value = clas.classId;
    option.textContent = `${clas.classname} ${clas.teacherName}`;
    classSelect.appendChild(option);
  });
}

async function updateStudentSelect(students) {
  const studentSelect = document.getElementById('student-name');
  studentSelect.innerHTML = '<option value="">Выберите ученика</option>';
  students.forEach(student => {
    const option = document.createElement('option');
    option.value = student.studentId;
    option.textContent = `${student.name} ${student.secondName}`;
    studentSelect.appendChild(option);
  });
}

async function updateTeacherSelect(teachers) {
  const teacherSelect = document.getElementById('class-teacher');
  teacherSelect.innerHTML = '<option value="">Выберите учителя</option>';
  teachers.forEach(teacher => {
    const option = document.createElement('option');
    option.value = teacher.id;
    option.textContent = `${teacher.firstname} ${teacher.lastname}`;
    teacherSelect.appendChild(option);
  });
}

async function updateStudentTable(students) {
  const studentsList = document.getElementById('student-list');
  studentsList.innerHTML = '';
  students.forEach((student, index) => {
    const row = document.createElement('tr');
    row.innerHTML = `
            <td style="display: none">${student.studentId}</td>
            <td>${index + 1}</td>
            <td>${student.name} ${student.secondName}</td>
            <td>
              <button class="btn-delete" type="button">Удалить</button>
            </td>
          `;
    studentsList.appendChild(row);
  });
}

document.getElementById('createClass').addEventListener('show.bs.modal',
    async function () {
      const teachers = await fetchTeachers();

      await updateTeacherSelect(teachers);
    });

document.getElementById('addStudentToClass').addEventListener('show.bs.modal',
    async function () {
      const modal = bootstrap.Modal.getInstance(
          document.getElementById('editClass'));
      modal.hide();

      const students = await fetchStudents();
      const classes = await fetchClasses();

      await updateStudentSelect(students);
      await updateClassesSelect(classes);
    });

document.querySelectorAll('.btn-edit.btn-secondary').forEach(button => {
  button.addEventListener('click', async function (e) {
    e.preventDefault();

    const formId = this.closest('tr').querySelector(
        'td:first-child').textContent;
    try {
      const students = await fetchStudentToClass(formId);

      await updateStudentTable(students);
    } catch (e) {

    }
  });
});

document.addEventListener('DOMContentLoaded', function () {
  const addClassForm = document.getElementById('addClass');
  const classModal = document.getElementById('createClass');
  const addStudentToClass = document.getElementById('addStudentForm');

  if (!addClassForm || !classModal || !addStudentToClass) {
    console.error('Не удалось найти один из необходимых элементов');
    return;
  }

  addClassForm.addEventListener('submit', async function (e) {
    e.preventDefault();

    const formData = new FormData(this);

    if (!formData.get('classname') || !formData.get('teacher')) {
      alert('Заполните все обязательные поля!');
      return;
    }

    try {
      const response = await fetch('/dairy-project/admin/class/add', {
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
      alert('Класс успешно создан!');
      location.reload();

    } catch (error) {
      console.error('Ошибка при создании класса:', error);
      alert(`Произошла ошибка при создании класса: ${error.message}`);
      location.reload();
    }
  });

  addStudentToClass.addEventListener('submit', async function (e) {
    e.preventDefault();

    const formData = new FormData(this);

    // if (!formData.get('student-name') || !formData.get('student-class')) {
    //   alert('Заполните все обязательные поля!');
    //   return;
    // }

    try {
      const response = await fetch('/dairy-project/admin/classes/add-student', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({
          studentId: formData.get('student-name'),
          classId: formData.get('student-class')
        })
      });

      if (!response.ok) {
        const errorData = await response.json();
        throw new Error(
            errorData.message || `Ошибка сервера: ${response.status}`);
      }

      const modal = bootstrap.Modal.getInstance(
          document.getElementById('addStudentToClass'));
      modal.hide();
      alert('Ученик успешно добавлен к классу!');
      location.reload();

    } catch (error) {
      console.error('Ошибка при добавлении ученика:', error);
      alert(`Произошла ошибка при добавлении ученика: ${error.message}`);
      location.reload();
    }
  });

});
