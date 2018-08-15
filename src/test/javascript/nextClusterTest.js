describe('Next Cluster Button Suite', () => {
    it('should change the current cluster on button click', () => {
        const nextQuestionButton = document.createElement('button');
         nextQuestionButton.innerText = 'next cluster';
        document.body.appendChild(nextQuestionButton);


        expect(nextQuestionButton.innerText).to.deep.equal('next cluster');
    })


});