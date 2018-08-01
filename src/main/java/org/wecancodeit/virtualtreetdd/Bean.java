package org.wecancodeit.virtualtreetdd;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Bean {
  @Id @GeneratedValue private Long id;

  @Lob private String example;
  private String questionNum;
  private String question;
  private String answer;
  private QuestionType questionType;

  protected enum QuestionType {
    TrueOrFalse,
    Checkboxes,
    FillInTheBlanks
  }

  @ManyToOne private Cluster cluster;

  /**
   * @param example - The example given before the question that is going to be asked
   * @param questionNum
   * @param question - The question that will be shown
   * @param answer
   * @param cluster - Cluster of which the bean is owned by
   */
  public Bean(
      QuestionType type,
      String example,
      String questionNum,
      String question,
      String answer,
      Cluster cluster) {
    this.questionType = type;
    this.example = example;
    this.questionNum = questionNum;
    this.question = question;
    this.answer = answer;
    this.cluster = cluster;
  }

  public Long getId() {
    return id;
  }

  public String getExample() {
    return example;
  }

  public String getQuestionNum() {
    return questionNum;
  }

  public String getQuestion() {
    return question;
  }

  public String getAnswer() {
    return answer;
  }

  public Cluster getCluster() {
    return cluster;
  }

  protected Bean() {}

  public QuestionType getQuestionType() { // TODO Auto-generated method stub
    return questionType;
  }
}
