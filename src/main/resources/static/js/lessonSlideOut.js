function toggleLessonView() {
  document.getElementById('slide-out-lesson').classList.toggle('openLesson');
  // document.getElementById('slide-out-lesson').classList.add('openLesson');
}

// function closeLessonView() {
//   document.getElementById('slide-out-lesson').classList.remove('openLesson');
//   document.getElementById('slide-out-lesson').classList.add('closedLesson');
// }

const openButton = document.querySelector('.openbtn');
openButton.addEventListener('click', toggleLessonView);

const closedButton = document.querySelector('.closebtn');
closedButton.addEventListener('click', toggleLessonView);