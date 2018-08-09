/* eslint-disable */

// This is so IE stops complaining when running tests
(function () {
  if ( typeof NodeList.prototype.forEach === "function" ) return false;
  NodeList.prototype.forEach = Array.prototype.forEach;
})();

const btnNextQuestion = document.getElementById('nextQuestion');
btnNextQuestion.setAttribute('disabled', 'true');

function setIdOfCheckedRadioButton() {
  const rdoButtons = document.querySelectorAll('input[type="radio"]');
  if (rdoButtons[0]) {
    rdoButtons.forEach((rdoButton) => {
      if (rdoButton.checked === false) {
        rdoButton.removeAttribute('id');
      } else {
        rdoButton.id = 'selectedAnswer';
      }
    });
  }
}

const btnSubmitAnswer = document.getElementById('submitAnswer');
const clusterBeansUl = document.querySelector('.clusterBeans');
function addEventListeners() {
  clusterBeansUl.addEventListener('click', setIdOfCheckedRadioButton);
  btnSubmitAnswer.addEventListener('click', getAnswerToCheck);
  btnSubmitAnswer.addEventListener('click', checkIfBeanIsLast);
}

addEventListeners();

function checkIfBeanIsLast() {
  const bean = document.getElementById('selectedAnswer');
  const beanQuestionNum = bean.value;
  const clusterSize = document.getElementById('clusterSize').innerText;
  if (beanQuestionNum === clusterSize) {
    btnSubmitAnswer.setAttribute('disabled', 'true');
  }
}

function checkIfAnswerIsCorrect(response) {
  if (this.status === 200 && this.readyState === 4) {
    const answer = JSON.parse(response.target.response);
    if (answer === true) {
      console.log("Yay you're right!");
      btnNextQuestion.removeAttribute('disabled');
    } else {
      console.log('Wrong...');
    }
  }
}

function getAnswerToCheck() {
  const rdoClicked = document.getElementById('selectedAnswer');
  const beanId = rdoClicked.getAttribute('class');
  const answerToCheck = rdoClicked.nextSibling.textContent.toLowerCase();
  console.log(answerToCheck.trim());
  const xhr = new XMLHttpRequest();
  xhr.open('GET', `/api/beans/${beanId}/checkanswer?answerToCheck=${answerToCheck}`, true);
  xhr.addEventListener('readystatechange', checkIfAnswerIsCorrect);
  xhr.send();
}
