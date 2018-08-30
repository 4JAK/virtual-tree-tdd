function goToNextCluster(response) {
  if (this.status === 200 && this.readyState === 4) {
    const cluster = JSON.parse(response.target.response);
    window.location.replace(`/cluster/${cluster.id}`);
  }
}

function getNextCluster() {
  const xhr = new XMLHttpRequest();
  const clusterId = document.querySelector('.cluster-beans').id;
  xhr.addEventListener('readystatechange', goToNextCluster);
  xhr.open('GET', `/api/clusters/${clusterId}/getNextCluster`, true);
  xhr.send();
}

function clusterIsLastInBranch(response) {
  if (this.status === 200 && this.readyState === 4) {
    const res = JSON.parse(response.target.response);
    if (res === true && document.URL.split('/')[4] === '3') {
      window.location.replace('/JavaTreeCompleted');
    }
  }
}

function isClusterLastInBranch() {
  const xhr = new XMLHttpRequest();
  const clusterId = document.querySelector('.cluster-beans').id;
  xhr.addEventListener('readystatechange', clusterIsLastInBranch);
  xhr.open('GET', `/api/clusters/${clusterId}/checkIfLastClusterOnTree?clusterId=${clusterId}`, true);
  xhr.send();
}

function beanIsLastInCluster(response) {
  if (this.status === 200 && this.readyState === 4) {
    const res = JSON.parse(response.target.response);
    if (res === true) {
      if (isClusterLastInBranch() === true) {
        window.location.replace(`/cluster/${document.URL.split('/')[4]}`);
      } else {
        document.getElementById('nextQuestionButton').innerText = 'Next Cluster';
        document.getElementById('nextQuestionButton').removeEventListener('click', getNextBeanQuestion);
        document.getElementById('nextQuestionButton').addEventListener('click', getNextCluster);
      }
    }
  }
}

function checkIfBeanIsLastInCluster() {
  const xhr = new XMLHttpRequest();
  const clusterId = document.URL.split('/')[4];
  const beanId = document.querySelector('.bean-label').id;
  xhr.addEventListener('readystatechange', beanIsLastInCluster);
  xhr.open('GET', `/api/clusters/${clusterId}/checkBean?beanId=${beanId}`, true);
  xhr.send();
}

function eventListeners() {
  const submitAnswer = document.getElementById('submitAnswer');
  submitAnswer.addEventListener('click', checkIfBeanIsLastInCluster);
}

eventListeners();
