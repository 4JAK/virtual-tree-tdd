/* eslint-disable */

describe('Submit Answer Button Suite', function() {

  const ul = document.createElement('ul');
  ul.setAttribute('class', 'clusterBeans');
  const li = document.createElement('li');
  const rdoButton1 = document.createElement('input');
  rdoButton1.setAttribute('type', 'radio');
  const rdoButton2 = document.createElement('input');
  rdoButton2.setAttribute('type', 'radio');
  rdoButton2.setAttribute('value', '5');
  const spanOfAnswer = document.createTextNode('TDD is a programming language.');
  const submitButton = document.createElement('button');
  submitButton.id= "submitAnswer";
  li.appendChild(rdoButton1);
  li.appendChild(rdoButton2);
  rdoButton2.appendChild(spanOfAnswer);
  ul.appendChild(li);
  ul.appendChild(submitButton);
  document.body.appendChild(ul);
  /* What it looks like
    <body>
      <ul>
        <li>
          <input type="radio" /> 
          <input type="radio" value="1">TDD is a programming language.</input> 
        </li>
        <button id="submitAnswer"></button>
      </ul>
      <footer>
      </footer>
    </body>
  */

  it('should return selectedAnswer for id when radio button is clicked', () => {
    rdoButton2.click();
    setIdOfCheckedRadioButton();
    expect(rdoButton2.id).to.deep.equal('selectedAnswer');
  });
  
  it('should return true for checked property of radio button', () => {
    expect(rdoButton2.checked).to.deep.equal(true);
  });

  it('should return true for checked property of radio button', () => {
    expect(rdoButton1.checked).to.deep.equal(false);
  });

  it('bean question num should be equal to cluster size', () => {
    const footer = document.createElement('footer');
    ul.appendChild(footer);
    const strong1 = document.createElement('strong');
    const strong2 = document.createElement('strong');
    footer.appendChild(strong2);
    footer.appendChild(strong1);
  strong1.setAttribute("id", "currentQuestionNum");
  strong1.innerText = rdoButton2.value
  strong2.setAttribute("id", "clusterSize");
  const textOfStrong2 = document.createTextNode("5");
  strong2.appendChild(textOfStrong2);

    const beanIsLast = checkIfBeanIsLastInCluster();
    expect(beanIsLast).to.deep.equal(true);

  });

  it('submit button should be disabled on last bean if true', () => {
    checkIfBeanIsLastInCluster()
    
    expect(submitButton.getAttribute('disabled')).to.deep.equal("true");
  })
  
});
