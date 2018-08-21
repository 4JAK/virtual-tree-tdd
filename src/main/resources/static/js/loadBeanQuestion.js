function renderBean(response) {
  if (this.status === 200 && this.readyState === 4) {
    const bean = JSON.parse(response.target.response);
    const beanQuestion = document.getElementById('beanQuestion');
    const imageForBeanLesson = document.getElementById('lessonImage');
    const beanLessonExample = document.getElementById('beanLessonExample');
    const beanAnswers = document.querySelector('.beanAnswers');

    if (bean.lesson.image != null) {
      imageForBeanLesson.setAttribute('src', bean.lesson.image);
    }

    beanLessonExample.innerHTML = '';
    beanLessonExample.innerHTML = bean.lesson.example;
    beanQuestion.innerHTML = bean.question;
    // We still have our Bean object, and what do our objects have?
    // Collections! And we can iterate over them like so
    beanAnswers.innerHTML = '';
    bean.answers.forEach((answer) => {
      beanAnswers.innerHTML += `
      <label id="${bean.id}" class="bean-label" for="radioGroup">
        <input class="bean-answer" name="radioGroup" type="radio" value="${bean.questionNum}">
          ${answer}
        </input>
      </label>`;
    });

    addEventListenersForButtons();
    document.getElementById('slide-out-lesson').classList.toggle('closedLesson');

    // Grab the strong tag from it's id
    const currentQuestionNum = document.getElementById('currentQuestionNum');
    // Set the innerHTML to the next bean's question num
    currentQuestionNum.innerText = bean.questionNum;
    document.getElementById('bean-tree').src = `/images/bean-${currentQuestionNum.innerText}.png`;

    // document.getElementById('submitAnswer').setAttribute('disabled', 'disabled');
    document.getElementById('nextQuestionButton').setAttribute('disabled', 'disabled');
    const beanLabels = document.querySelectorAll('.bean-label');
    if (beanLabels[0]) {
      beanLabels.forEach((label) => {
        console.log('hit adding event listeners to new labels');
        
        label.addEventListener('click', checkRadio);
      });
    }

  }
}


// API call for grabbing the next bean in the cluster
function getNextBeanQuestion() {
  if (checkIfBeanIsLastInCluster() === true) {
    console.log('the bean is last!');
  } else {
    document.querySelector('.modal-screen').classList.remove('modal-open');
    const xhr = new XMLHttpRequest();
    // since the class has a list of classes for the,
    // we grab the second class for the cluster ID
    const clusterId = document.querySelector('.clusterBeans').id;
    // clusterId = parseInt(clusterId, 10);
    // Grab current question number from the inputs value,
    // since the inputs value is set to the question number
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
