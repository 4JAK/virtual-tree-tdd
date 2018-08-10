<<<<<<< HEAD
=======
// require('babel-register');
// require('babel-polyfill');

>>>>>>> master
/* eslint-disable */

describe('Submit Answer Button Suite', function() {

  const ul = document.createElement('ul');
<<<<<<< HEAD
  ul.setAttribute('class', 'clusterBeans');
=======
>>>>>>> master
  const li = document.createElement('li');
  const rdoButton1 = document.createElement('input');
  rdoButton1.setAttribute('type', 'radio');
  const rdoButton2 = document.createElement('input');
  rdoButton2.setAttribute('type', 'radio');
  rdoButton2.setAttribute('value', '1');
  const spanOfAnswer = document.createTextNode('TDD is a programming language.');
  const submitButton = document.createElement('button');
  li.appendChild(rdoButton1);
  li.appendChild(rdoButton2);
  rdoButton2.appendChild(spanOfAnswer);
  ul.appendChild(li);
  ul.appendChild(submitButton);
  document.body.appendChild(ul);
<<<<<<< HEAD
  /* What it looks like
    <body>
      <ul>
        <li>
          <input type="radio" /> 
          <input type="radio" value="1">TDD is a programming language.</input> 
        </li>
        <button id="submitAnswer"></button>
      </ul>
    </body>
  */
=======
>>>>>>> master

  it('should return selectedAnswer for id when radio button is clicked', () => {
    rdoButton2.click();
    setIdOfCheckedRadioButton();
    expect(rdoButton2.id).to.deep.equal('selectedAnswer');
  });
  
  it('should return true for checked property of radio button', () => {
    expect(rdoButton2.checked).to.deep.equal(true);
  });
<<<<<<< HEAD

  it('should return true for checked property of radio button', () => {
    expect(rdoButton1.checked).to.deep.equal(false);
  });

  it('bean question num should be equal to cluster size', () => {
    const bean = document.getElementById('selectedAnswer');
    checkIfBeanIsLast();
    expect(bean.getAttribute('disabled')).to.deep.equal(true);
  });
});
=======
  
  // it('should return true from checkAnswerOfBean API call ', () => {
  //   const promise = webix.ajax().get(`http://localhost:8080/api/beans/1/checkanswer?answerToCheck=${rdoButton2.innerText}`, JSON.stringify(test));
  //   promise.then(function (resp) {
  //     console.log('resp', app.util.inspect(resp));
  //     done();
  //   }).fail(function (err) {
  //     console.log('err', app.util.inspect(promise));
  //     throw(promise.state);
  //   });
  // });
});
>>>>>>> master
