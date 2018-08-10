function renderBean(response) {  
  if (this.status === 200 && this.readyState === 4) {
    const bean = JSON.parse(response.target.response);
    const fieldset = document.querySelector('.clusterBeans');
    fieldset.innerHTML = `
    <legend class="questionLegend">
      <strong class="beanQuestion">${bean.question}</strong>
    </legend>
    `;
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

    // Grab the strong tag from it's id
    const currentQuestionNum = document.getElementById('currentQuestionNum');
    // Set the innerHTML to the next bean's question num
    currentQuestionNum.innerHTML = `${bean.questionNum}`;

    btnNextQuestion.setAttribute('disabled', 'true');
  }
}

// API call for grabbing the next bean in the cluster
function getNextBeanQuestion() {
  const xhr = new XMLHttpRequest();
  const clusterId = document.URL.split('/')[4];
  const bean = document.getElementById('selectedAnswer');
  const beanQuestionNum = bean.value;
  const clusterSize = document.getElementById('clusterSize').innerText;
  if (beanQuestionNum === clusterSize) {
    btnNextQuestion.setAttribute('disabled', 'true');
  } 
  xhr.open('GET', `/api/clusters/${clusterId}/getnextbean?currentBeanQuestionNum=${beanQuestionNum}`, true);
  xhr.addEventListener('readystatechange', renderBean);
  xhr.send();
}

// Currently, btnNextQuestion doesn't exist in this file, however,
// we're not declaring it with a const because it DOES exist in our other files,
// therefore throwing an error of redeclaration.
// 
btnNextQuestion.addEventListener('click', getNextBeanQuestion);
