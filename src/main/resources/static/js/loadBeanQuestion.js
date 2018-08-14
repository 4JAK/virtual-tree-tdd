function renderBean(response) {
  if (this.status === 200 && this.readyState === 4) {
    console.log('hit render bean');
    const bean = JSON.parse(response.target.response);
    const beanQuestion = document.getElementById('beanQuestion');
    const imageForBeanLesson = document.getElementById('lessonImage');
    const beanLessonExample = document.getElementById('beanLessonExample');
    const beanAnswers = document.querySelector('.beanAnswers');

    if (bean.lesson.image != null) {
      imageForBeanLesson.setAttribute('src', bean.lesson.image);
    } else {
      imageForBeanLesson.setAttribute('src', '');
    }
    beanLessonExample.innerHTML = '';
    beanLessonExample.innerHTML = bean.lesson.example;
    beanQuestion.innerHTML = bean.question;
    // We still have our Bean object, and what do our objects have?
    // Collections! And we can iterate over them like so
    beanAnswers.innerHTML = '';
    bean.answers.forEach((answer) => {
      beanAnswers.innerHTML += `
      <label for="radioGroup">
        <input class="${bean.id}" name="radioGroup" type="radio" value="${bean.questionNum}">
          ${answer}
        </input>
      </label>`;
    });

    document.getElementById('currentQuestionNum').setAttribute('value', `${bean.questionNum}`);
    document.getElementById('currentQuestionNum').innerText = bean.questionNum;

    // Grab the strong tag from it's id
    const currentQuestionNum = document.getElementById('currentQuestionNum');
    // Set the innerHTML to the next bean's question num
    currentQuestionNum.innerHTML = bean.questionNum;

    document.getElementById('nextQuestion').setAttribute('disabled', 'true');
  }
}

// API call for grabbing the next bean in the cluster
function getNextBeanQuestion() {
  const xhr = new XMLHttpRequest();
  // since the class has a list of classes for the,
  // we grab the second class for the cluster ID
  const clusterId = document.getElementById('clusterId').getAttribute('value');
  // clusterId = parseInt(clusterId, 10);
  // Grab current question number from the inputs value,
  // since the inputs value is set to the question number
  const beanQuestionNum = document.getElementById('currentQuestionNum').getAttribute('value');
  // Grab the cluster size
  const clusterSize = document.getElementById('clusterSize');
  // Grab the button for going to the next question
  const btnNextQuestion = document.getElementById('nextQuestion');
  if (beanQuestionNum === clusterSize) {    
    btnNextQuestion.setAttribute('disabled', 'true');
  }
  console.log('hit next bean function');
  xhr.open('GET', `/api/clusters/${clusterId}/getnextbean?currentBeanQuestionNum=${beanQuestionNum}`, true);
  xhr.addEventListener('readystatechange', renderBean);
  xhr.send();
}

function addEventListeners() {
  const btnNextQuestion = document.getElementById('nextQuestion');
  btnNextQuestion.addEventListener('click', getNextBeanQuestion);
}
addEventListeners();
