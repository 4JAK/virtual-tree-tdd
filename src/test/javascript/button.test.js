// require('babel-register');
// require('babel-polyfill');

/* eslint-disable */

describe('Submit Answer Button Suite', function() {

  const ul = document.createElement('ul');
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

  it('should return selectedAnswer for id when radio button is clicked', () => {
    rdoButton2.click();
    setIdOfCheckedRadioButton();
    expect(rdoButton2.id).to.deep.equal('selectedAnswer');
  });
  
  it('should return true for checked property of radio button', () => {
    expect(rdoButton2.checked).to.deep.equal(true);
  });
  
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