function goToNextCluster(response) {
  if (this.status === 200 && this.readyState === 4) {
    const cluster = JSON.parse(response.target.response);
    console.log(cluster.branch);
    window.location.replace(`/cluster/${cluster.id}`);
  }
}

function getNextCluster() {
  const xhr = new XMLHttpRequest();
  const clusterId = document.querySelector('.clusterBeans').id;
  xhr.addEventListener('readystatechange', goToNextCluster);
  xhr.open('GET', `/api/clusters/${clusterId}/getNextCluster`, true);
  xhr.send();
}

function beanIsLastInCluster(response) {
  if (this.status === 200 && this.readyState === 4) {
    const res = JSON.parse(response.target.response);
    if (res === true) {
      document.getElementById('nextQuestionButton').innerText = 'Next Cluster';
      document.getElementById('nextQuestionButton').removeEventListener('click', getNextBeanQuestion);
      document.getElementById('nextQuestionButton').addEventListener('click', getNextCluster);
      console.log('is last!');
      // return true;
    }
    console.log('Is not last in cluster');
    // return false;
  }
}

function checkIfBeanIsLastInCluster() {
  const xhr = new XMLHttpRequest();
  const clusterId = document.querySelector('.clusterBeans').id;
  const beanId = document.querySelector('.bean-label').id;
  console.log(`clusterid: ${clusterId} | beanId: ${beanId}`);

  xhr.addEventListener('readystatechange', beanIsLastInCluster);
  xhr.open('GET', `/api/clusters/${clusterId}/checkBean?beanId=${beanId}`, true);
  xhr.send();
}

function eventListeners() {
  const submitAnswer = document.getElementById('submitAnswer');
  submitAnswer.addEventListener('click', checkIfBeanIsLastInCluster);
}

eventListeners();
