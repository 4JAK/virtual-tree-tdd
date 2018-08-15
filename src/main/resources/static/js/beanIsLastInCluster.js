function beanIsLastInCluster(response) {
  if (this.status === 200 && this.readyState === 4) {
    const res = JSON.parse(response.target.response);
    if (res === true) {
      document.getElementById('nextQuestion').innerText = 'Next Cluster';
      console.log('is last!');
      
    } else {
      console.log('Is not last in cluster');
    }
  }
}

function checkIfBeanIsLastInCluster() {
  const xhr = new XMLHttpRequest();
  const clusterId = document.getElementById('clusterId').getAttribute('value');
  const beanId = document.getElementById('selectedAnswer').getAttribute('class');
  xhr.addEventListener('readystatechange', beanIsLastInCluster);
  xhr.open('GET', `/api/clusters/${clusterId}/checkBean?beanId=${beanId}`, true);
  xhr.send();
}

function eventListeners() {
  const submitAnswer = document.getElementById('submitAnswer');
  submitAnswer.addEventListener('click', checkIfBeanIsLastInCluster);
}

eventListeners();
