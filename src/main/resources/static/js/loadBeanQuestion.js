function renderBean(response) {
  console.log(response);
  if (this.status === 200 && this.readyState === 4) {
    const bean = JSON.parse(response.target.response);
    const fieldset = document.querySelector('.clusterBeans');
    fieldset.innerHTML = `
    <legend class="questionLegend">
      <strong class="beanQuestion">${bean.question}</strong>
    </legend>`;
    // We still have our Bean object, and what do our objects have?
    // Collections! And we can iterate over them like so
    bean.answers.forEach((answer) => {
      fieldset.innerHTML += `
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
  console.log(clusterId);
  
  if (beanQuestionNum === clusterSize) {
    console.log('hit true');
    
    btnNextQuestion.setAttribute('disabled', 'true');
  }

  
  xhr.open('GET', `/api/clusters/${clusterId}/getnextbean?currentBeanQuestionNum=${beanQuestionNum}`, true);
  xhr.addEventListener('readystatechange', renderBean);
  xhr.send();
}


function addEventListeners() {
  const btnNextQuestion = document.getElementById('nextQuestion');
  btnNextQuestion.addEventListener('click', getNextBeanQuestion);
}
addEventListeners();

// Currently, btnNextQuestion doesn't exist in this file, however,
// we're not declaring it with a const because it DOES exist in our other files,
// therefore throwing an error of redeclaration.
// 
