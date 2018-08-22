function goToNextCluster(response) {
  if (this.status === 200 && this.readyState === 4) {
    const cluster = JSON.parse(response.target.response);
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

function clusterIsLastInBranch(response) {
  console.log(response);  
  if (this.status === 200 && this.readyState === 4) {
    const res = JSON.parse(response.target.response);
    if (res === true) {
      alert(`Hit API call for cluster is last in branch`);
    }
  }
}

function isClusterLastInBranch() {
  const xhr = new XMLHttpRequest();
  const hrefArray = document.URL.split('/');
  const clusterId = hrefArray[4];
  xhr.addEventListener('readystatechange', clusterIsLastInBranch);
  xhr.open('GET', `/api/clusters/${clusterId}/checkIfLastClusterOnTree?clusterId=${clusterId}`, true);
  xhr.send();
}

function beanIsLastInCluster(response) {
  if (this.status === 200 && this.readyState === 4) {
    const res = JSON.parse(response.target.response);
    if (res === true) {
      if (isClusterLastInBranch() === true) {
        alert('Hit cluster is last in branch')
        window.location.replace(`/cluster/${document.URL.split('/')[4]}`);
      } else {
        document.getElementById('nextQuestionButton').innerText = 'Next Cluster';
        document.getElementById('nextQuestionButton').removeEventListener('click', getNextBeanQuestion);
        document.getElementById('nextQuestionButton').addEventListener('click', getNextCluster);
        alert('Hit API for cluster is not last in branch, but bean is');
      }
    }
  }
}

function checkIfBeanIsLastInCluster() {
  const xhr = new XMLHttpRequest();
  const clusterId = document.querySelector('.clusterBeans').id;
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
