function goToNextCluster(response) {
  if (this.status === 200 && this.readyState === 4) {
    const cluster = JSON.parse(response.target.response);
    console.log(cluster.branch);
    window.location.replace(`/cluster/${cluster.id}`);
  }
}

function getNextCluster() {
  const xhr = new XMLHttpRequest();
  const clusterId = document.getElementById('clusterId').getAttribute('value');
  xhr.addEventListener('readystatechange', goToNextCluster);
  xhr.open('GET', `/api/clusters/${clusterId}/getNextCluster`, true);
  xhr.send();
}

function beanIsLastInCluster(response) {
  if (this.status === 200 && this.readyState === 4) {
    const res = JSON.parse(response.target.response);
    if (res === true) {
      document.getElementById('nextQuestion').innerText = 'Next Cluster';
      document.getElementById('nextQuestion').removeEventListener('click', getNextBeanQuestion);
      document.getElementById('nextQuestion').addEventListener('click', getNextCluster);
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
