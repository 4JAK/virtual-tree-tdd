/* eslint-disable */

// When called, will loop throug all radio buttons
// and see if their property 'checked' is true
// if a button is checked, will set it's id attribute to 'selectedAnswer' 
function setIdOfCheckedRadioButton() {
  // Query for all tag inputs of type radio
  const rdoButtons = document.querySelectorAll('input[type="radio"]');
  // if not null by checking if there's at least 1 element in the query
  if (rdoButtons[0]) {
    // for each queried button
    rdoButtons.forEach((rdoButton) => {
      if (rdoButton.checked === false) {
        rdoButton.removeAttribute('id');
      } else {
        rdoButton.id = 'selectedAnswer';
      }
    });
  }
}

function checkRadio(event) {
  const labelClicked = event.target;
  const rdoClick = labelClicked.childNodes[1];
  rdoClick.checked = true;
}

// Grab the unordered list of where the bean is at
// add event listeners to the unordered list and submit answer button
function addEventListeners() {
  const clusterBeansUl = document.querySelector('.clusterBeans');
  clusterBeansUl.addEventListener('click', setIdOfCheckedRadioButton);
  clusterBeansUl.addEventListener('click', enableSubmitButtonOnRadioSelect);
  const btnSubmitAnswer = document.getElementById('submitAnswer');
  btnSubmitAnswer.addEventListener('click', getAnswerToCheck);
  const labelsForBeanAnswer = document.querySelectorAll('.bean-answer-label');
  if(labelsForBeanAnswer[0]) {
    labelsForBeanAnswer.forEach((label) => {
      label.addEventListener('click', checkRadio);
    });
  }
}

// Call method on page load
addEventListeners();

function checkIfAnswerIsCorrect(response) {
  // this being xhr.
  // Why?
  /*
    We were originally shown readystatechange like this: 
    xhr.onreadystatechange = (response) => {
      if (xhr.status === 200 && xhr.readyState === 4) {
        // parsing response JSON...
      }
    }

    And this isn't bad. However, these are called anonymous functions.
    Anonymous functions are called anonymous because 
      they are called dynamically at runtime, and they have no function name.

    With adding the event listener, this refers to what triggered the event listener.
    In this case, our xhr request.

    My personal preference is to ideally use zero anonymous functions.
    Reason being is that may want to use that part of the code again,
    and without putting that piece of code in it's own function,
    I would have to copy paste code everywhere, instead of just calling the function name.

    Perfect exmaple of this is rendering the page content on certain actions.
    If I have multiple different functions that modify how the page is rendered,
    I will more than likely have a function that changes one part of the page 
    from different actions on the page.

    Think back to Artists and albums, and how we rendered a specific collection
    of artists, regardless if deleted, added, or edited an artist, we still rendered
    that specific collection of artists.

  */
  if (this.status === 200 && this.readyState === 4) {
    const answer = JSON.parse(response.target.response);
    const selectedAnswer = document.getElementById('selectedAnswer');
    // answer being the returned value from the API call.
    // Since it's a boolean API call, 
    // we only have to check against true or false conditions.
    if (answer === true) {
      console.log("Yay you're right!");
      document.querySelector('.next-question-modal').removeAttribute('hidden');
      // then remove the disabled attribute from the button since the answer was correct.
      // and also the submit answer button because,
      // we don't want them submitting more than once, once they are correct
      // document.getElementById('submitAnswer').removeAttribute('disabled');
      document.getElementById('nextQuestion').removeAttribute('disabled');
      // checkIfBeanIsLastInCluster();
    } else {
      // Ideally, if the value returned is false,
      // we want the modal to pop up, and possibly edit the background color of the text
      // indicating whether or not they were wrong. If false, bg-color will be red.

      // With the modal, we can add it in the HTML instead of a popup,
      // with text being added inside, indicating whether or not they were correct.
      selectedAnswer.setAttribute('disabled', 'true');
      selectedAnswer.parentElement.classList.add('incorrectAnswer');
      document.getElementById('submitAnswer').setAttribute('disabled', 'true');
      console.log('Wrong...');
    }
  }
}

function enableSubmitButtonOnRadioSelect() {
  // if the id exists, which it should
  if (document.getElementById('selectedAnswer')) {
    document.getElementById('submitAnswer').removeAttribute('disabled');
  }
}

function getAnswerToCheck() {
  // Grab the currently selected radio button
  const rdoClicked = document.getElementById('selectedAnswer');
  // From the radio, it's class attribute is the bean id
  const beanId = rdoClicked.getAttribute('value');
  // Since it's a radio button, we need to grab it's text, 
  // which is the sibling of the input
  // We lowercase it to make sure that when we check it against the server,
  // all answers are checked with the formatting standard of lowercase
  const answerToCheck = rdoClicked.nextSibling.textContent.toLowerCase();
  const xhr = new XMLHttpRequest();
  // Pass the beanId and answerToCheck variables to our API call
  xhr.open('GET', `/api/beans/${beanId}/checkanswer?answerToCheck=${answerToCheck}`, true);
  // This is immediately hit, now going to checkIfAnswerIsCorrect method
  // Explanation of adding event listener instead of anonymous functions in method
  xhr.addEventListener('readystatechange', checkIfAnswerIsCorrect);
  xhr.send();
}
