// describe('next question button suite', () => {
//   it('should change the current question num on button click', () => {

//     const beanObj = JSON.stringify({ 
//       id: 2,
//       questionNum: 2,
//       questionType: 'MultipleChoice',
//       question: 'Why do we use TDD?',
//       answers: ['We use TDD so that the code we produce is immutable and nothing can be added to the code.',
//                   'We use TDD to decrease the speed in which it takes for a project to be developed',
//                   'We use TDD to use less programmers when developing a project.',
//                   'We use TDD to make sure that our code is doing what we expect it to do.'],
//       correctAnswer: 'We use TDD to make sure that our code is doing what we expect it to do.',
//     });

//     const clusterFieldset = document.createElement('fieldset');
//     clusterFieldset.setAttribute('class', 'clusterBeans 1');
//     clusterFieldset.setAttribute('id', 'clusterId');

//     const footer = document.createElement('footer');
//     const strongQuestionNum = document.createElement('strong');
//     strongQuestionNum.id = 'currentQuestionNum';
//     strongQuestionNum.innerText = '1';

//     const strongClusterSize = document.createElement('strong');
//     strongClusterSize.setAttribute('id', 'clusterSize');
//     strongClusterSize.innerText = '5';

//     const nextQuestionButton = document.createElement('button');
//     nextQuestionButton.setAttribute('id', 'nextQuestion');

//     footer.appendChild(strongQuestionNum);
//     footer.appendChild(strongClusterSize);

//     document.body.appendChild(clusterFieldset);
//     document.body.appendChild(footer);
//     document.body.appendChild(nextQuestionButton);

//     function renderBean(response) {
//       this.status = '200';
//       this.readyState = '4';
//       if (this.status === 200 && this.readyState === 4) {
//         console.log('hit render bean');
//         const bean = JSON.parse(response.target.response);
//         const fieldset = document.querySelector('.clusterBeans');
//         fieldset.innerHTML = `
//         <legend class="questionLegend">
//           <strong class="beanQuestion">${bean.question}</strong>
//         </legend>`;
//         // We still have our Bean object, and what do our objects have?
//         // Collections! And we can iterate over them like so
//         bean.answers.forEach((answer) => {
//           fieldset.innerHTML += `
//           <label for="radioGroup">
//             <input class="${bean.id}" name="radioGroup" type="radio" value="${bean.questionNum}">
//               ${answer}
//             </input>
//           </label>`;
//         });
    
//         document.getElementById('currentQuestionNum').setAttribute('value', `${bean.questionNum}`);
//         document.getElementById('currentQuestionNum').innerText = bean.questionNum;
    
//         // Grab the strong tag from it's id
//         const currentQuestionNum = document.getElementById('currentQuestionNum');
//         // Set the innerHTML to the next bean's question num
//         currentQuestionNum.innerHTML = bean.questionNum;
    
//         document.getElementById('nextQuestion').setAttribute('disabled', 'true');
//       }
//     }

//     function getNextBeanQuestion() {
//       const xhr = new XMLHttpRequest();
//       // since the class has a list of classes for the,
//       // we grab the second class for the cluster ID
//       const clusterId = document.getElementById('clusterId').getAttribute('value');
//       // clusterId = parseInt(clusterId, 10);
//       // Grab current question number from the inputs value,
//       // since the inputs value is set to the question number
//       const beanQuestionNum = document.getElementById('currentQuestionNum').getAttribute('value');
//       // Grab the cluster size
//       const clusterSize = document.getElementById('clusterSize');
//       // Grab the button for going to the next question
//       const btnNextQuestion = document.getElementById('nextQuestion');
//       if (beanQuestionNum === clusterSize) {    
//         btnNextQuestion.setAttribute('disabled', 'true');
//       }
//       console.log('hit next bean function');
      
//       xhr.open('GET', `/api/clusters/${clusterId}/getnextbean?currentBeanQuestionNum=${beanQuestionNum}`, true);
//       xhr.addEventListener('readystatechange', renderBean);
//       xhr.send();
//     }
    
//     nextQuestionButton.addEventListener('click', getNextBeanQuestion);
//     nextQuestionButton.click();
//     // renderBean(beanObj);
//     expect(strongQuestionNum.innerText).to.deep.equal('2');
//   });
// });
