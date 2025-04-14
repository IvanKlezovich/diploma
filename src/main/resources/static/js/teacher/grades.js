let activeSortColumn = null;

document.addEventListener('DOMContentLoaded', function () {
  const sortButtons = document.querySelectorAll('.sort-btn');

  sortButtons.forEach(button => {
    let sortState = 0;

    button.addEventListener('click', function () {
      // Если нажата другая колонка, сбрасываем предыдущую сортировку
      if (activeSortColumn !== null && activeSortColumn !== parseInt(
          this.dataset.column)) {
        document.querySelector(
            `.sort-btn[data-column="${activeSortColumn}"]`).textContent = '↑↓';
        activeSortColumn = null;
      }

      // Если сортировка уже включена для этой колонки, просто меняем направление
      if (activeSortColumn === parseInt(this.dataset.column)) {
        sortState = (sortState + 1) % 3;

        if (sortState === 0) {
          activeSortColumn = null;
        }
      } else {
        // Начинаем новую сортировку
        sortState = 1;
        activeSortColumn = parseInt(this.dataset.column);
      }

      // Обновляем внешний вид кнопки
      switch (sortState) {
        case 0:
          this.textContent = '↑↓';
          break;
        case 1:
          this.textContent = '↑';
          break;
        case 2:
          this.textContent = '↓';
          break;
      }

      // Если сортировка включена, выполняем сортировку
      if (sortState > 0) {
        const column = parseInt(this.dataset.column);
        const order = sortState === 1 ? 'asc' : 'desc';
        sortTable(column, order);
      }
    });
  });
});

function sortTable(column, order) {
  const table = document.querySelector('table');
  const tbody = table.querySelector('tbody');

  const rows = Array.from(tbody.querySelectorAll('tr'));

  rows.sort((a, b) => {
    const aValue = a.cells[column].textContent;
    const bValue = b.cells[column].textContent;

    if (order === 'asc') {
      return aValue.localeCompare(bValue);
    } else {
      return bValue.localeCompare(aValue);
    }
  });

  tbody.innerHTML = '';
  rows.forEach(row => tbody.appendChild(row));
}
