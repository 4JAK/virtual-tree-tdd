function renderBean(response) {  
  if (this.status === 200 && this.readyState === 4) {
    const bean = JSON.parse(response.target.response);
    const ul = document.querySelector('.clusterBeans');
    ul.innerHTML = `
    <li class="bean">
      <p class="beanQuestion">${bean.question}</p>
    </li>
    `;
    const beanQuestionTag = document.querySelector('.beanQuestion');
    bean.answers.forEach((answer) => {
      ul.innerHTML += `
      <input class="${bean.id}" type="radio" name="radioGroup" value="${bean.questionNum}">
        ${answer}
      </input>`;
    });

    btnNextQuestion.setAttribute('disabled', 'true');
  }
}

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


btnNextQuestion.addEventListener('click', getNextBeanQuestion);
