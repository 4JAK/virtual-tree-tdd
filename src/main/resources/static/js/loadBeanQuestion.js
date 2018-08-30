function renderBean(response) {
  if (this.status === 200 && this.readyState === 4) {
    const responseBean = JSON.parse(response.target.response);
    const imageForBeanLesson = document.getElementById('beanLessonImage');
    const beanLessonExample = document.querySelector('.bean-lesson');
    const sectionBean = document.querySelector('.bean');

    beanLessonExample.innerHTML = '';
    beanLessonExample.innerHTML = responseBean.lesson.example;
    // We still have our Bean object, and what do our objects have?
    // Collections! And we can iterate over them like so
    sectionBean.innerHTML = '';
    sectionBean.innerHTML = responseBean.question;
    responseBean.answers.forEach((answer) => {
      sectionBean.innerHTML += `
      <label id="${responseBean.id}" class="bean-label" for="radioGroup">
        <input class="rdo-bean-answer" name="radioGroup" type="radio" value="${responseBean.questionNum}">
          ${answer}
        </input>
      </label>`;
    });
    
    if (responseBean.lesson.image != null) {
      imageForBeanLesson.setAttribute('src', responseBean.lesson.image);
      beanLessonExample.firstChild.classList.add('bean-lesson-with-image');
    } else {
      beanLessonExample.firstChild.classList.remove('bean-lesson-with-image');
    }
    
    addEventListenersForButtons();
    document.getElementById('slide-out-lesson').classList.toggle('closedLesson');

    // Grab the strong tag from it's id
    const currentQuestionNum = document.getElementById('currentQuestionNum');
    // Set the innerHTML to the next bean's question num
    currentQuestionNum.innerText = responseBean.questionNum;
    document.getElementById('bean-tree').src = `/images/bean-${currentQuestionNum.innerText}.png`;

    document.getElementById('nextQuestionButton').setAttribute('disabled', 'disabled');
  }
}


// API call for grabbing the next bean in the cluster
function getNextBeanQuestion() {
  if (checkIfBeanIsLastInCluster() === true) {
    console.log('the bean is last!');
  } else {
    document.querySelector('.modal-screen').classList.remove('modal-open');
    const xhr = new XMLHttpRequest();
    const clusterId = document.querySelector('.cluster-beans').id;
    const beanQuestionNum = document.getElementById('currentQuestionNum').innerText;
    xhr.open('GET', `/api/clusters/${clusterId}/getnextbean?currentBeanQuestionNum=${beanQuestionNum}`, true);
    xhr.addEventListener('readystatechange', renderBean);
    xhr.send();
  }
}

function addEventListeners() {
  const btnNextQuestion = document.getElementById('nextQuestionButton');
  btnNextQuestion.addEventListener('click', getNextBeanQuestion);
}

addEventListeners();
