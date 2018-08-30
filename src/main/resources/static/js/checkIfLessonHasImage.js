// if the lesson has an image,
// we need to set the margin to allow enough space for the image to not overlap
// the lesson text
function checkIfLessonHasImage() {
  if (document.getElementById('beanLessonImage')) {
    document.querySelector('.bean-lesson').firstChild.classList.add('bean-lesson-with-image');
  } else {
    document.querySelector('.bean-lesson').firstChild.classList.remove('bean-lesson-with-image');
  }
}

checkIfLessonHasImage();