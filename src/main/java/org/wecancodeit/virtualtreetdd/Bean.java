package org.wecancodeit.virtualtreetdd;

import java.util.Collection;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Bean {
  @Id @GeneratedValue private Long id;

  @JsonIgnore @ManyToOne private Cluster cluster;

  @ManyToOne private Lesson lesson;

  private int questionNum;
  private QuestionType questionType;
  @Lob private String question;
  @ElementCollection private Collection<String> answers;
  private String correctAnswer;
  private boolean completedQuestion;

  /**
   * @param cluster - The 'Lesson' that the bean is attached to | Cluster
   * @param lesson - The lesson that is used to display the example for the bean | Lesson
   * @param questionNum | String
   * @param questionType - The question that will be shown i.e. TrueOrFalse, FillInTheBlanks,
   * @param question - Question to ask | String
   * @param correctAnswer - The answer that is correct from the list of answers
   * @param answers - Collection of answers, only 1 is correct | Collection<String>
   */
  public Bean(
      Cluster cluster,
      Lesson lesson,
      int questionNum,
      QuestionType type,
      String question,
      String correctAnswer,
      Collection<String> answers) {
    this.cluster = cluster;
    this.lesson = lesson;
    this.questionNum = questionNum;
    this.questionType = type;
    this.question = question;
    this.correctAnswer = correctAnswer;
    this.answers = answers;
    this.completedQuestion = false;
  }

  @Override
  public String toString() {
    return "Bean [id="
        + id
        + ",\ncluster="
        + cluster
        + ",\nlesson="
        + lesson
        + ",\nquestionNum="
        + questionNum
        + ",\nquestionType="
        + questionType
        + ",\nquestion="
        + question
        + ",\nanswers="
        + answers
        + ",\ncorrectAnswer="
        + correctAnswer
        + "]";
  }

  public Long getId() {
    return id;
  }

  public String getQuestion() {
    return question;
  }

  public int getQuestionNum() {
    return questionNum;
  }

  public String getCorrectAnswer() {
    return correctAnswer;
  }

  public Collection<String> getAnswers() {
    return answers;
  }

  public String getQuestionType() {
    return questionType.toString();
  }

  public Cluster getCluster() {
    return cluster;
  }

  public Lesson getLesson() {
    return lesson;
  }
  
  public boolean isCompletedQuestion() {
	return completedQuestion;
  }	

  public void setCompletedQuestion() {
	this.completedQuestion = true;
  }

public Bean() {}
}
