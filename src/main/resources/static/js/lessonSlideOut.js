function toggleLessonView() {
  document.getElementById('slide-out-lesson').classList.toggle('closedLesson');
}

const openButton = document.querySelector('.openbtn');
openButton.addEventListener('click', toggleLessonView);

const closedButton = document.querySelector('.closebtn');
closedButton.addEventListener('click', toggleLessonView);
