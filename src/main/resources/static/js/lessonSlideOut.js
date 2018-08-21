function toggleLessonView() {
  document.getElementById('slide-out-lesson').classList.toggle('closedLesson');
  const lessonButtonText = document.querySelector('.openbtn').innerHTML;  
  if (document.getElementById('slide-out-lesson').classList.contains('closedLesson')) {
    document.querySelector('.openbtn').innerHTML = '☰ Lesson';
  } else {
    document.querySelector('.openbtn').innerHTML = '\u00D7 Lesson';
  }
}

const openButton = document.querySelector('.openbtn');
openButton.addEventListener('click', toggleLessonView);
