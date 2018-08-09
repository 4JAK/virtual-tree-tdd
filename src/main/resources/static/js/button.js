/* eslint-disable */

// This is so IE stops complaining when running tests
(function () {
  if ( typeof NodeList.prototype.forEach === "function" ) return false;
  NodeList.prototype.forEach = Array.prototype.forEach;
})();

function setIdOfCheckedRadioButton() {
  // console.log(`Target: ${event.target}`);
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

// function addEventListeners() {
// }
// addEventListeners();

function checkIfAnswerIsCorrect(response) {
  if (this.status === 200 && this.readyState === 4) {
    const answer = JSON.parse(response.target.response);
    if (answer === true) {
      console.log("Yay you're right!");
    } else {
      console.log('Wrong...');
      
    }
  }
}

function getAnswerToCheck() {
  const rdoClicked = document.getElementById('selectedAnswer');
  const beanId = rdoClicked.value;
  const answerToCheck = rdoClicked.textContent;
  const xhr = new XMLHttpRequest();
  xhr.open('GET', `/api/beans/${beanId}/checkanswer?answerToCheck=${answerToCheck}`, true);
  xhr.addEventListener('readystatechange', checkIfAnswerIsCorrect);
  xhr.send();
}

// const clusterBeansUl = document.querySelector('.clusterBeans');
// const btnSubmitAnswer = document.getElementById('submitAnswer');
// clusterBeansUl.addEventListener('click', setIdOfCheckedRadioButton);
// btnSubmitAnswer.addEventListener('click', getAnswerToCheck);