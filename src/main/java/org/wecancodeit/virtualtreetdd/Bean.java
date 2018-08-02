package org.wecancodeit.virtualtreetdd;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Bean {
  @Id @GeneratedValue private Long id;

  @ManyToOne private Cluster cluster;
  private String questionNum;
  private QuestionType questionType;
  @Lob private String question;
  private String answer;

  protected enum QuestionType {
    Drag_n_Drop,
    FillInTheBlanks,
    MultipleChoice,
    TrueOrFalse,
  }

  /**
   * @param cluster - The 'Lesson' that the bean is attached to | Cluster DragNDrop, or
   *     MultipleChoice | QuestionType
   * @param questionNum | String
   * @param questionType - The question that will be shown i.e. TrueOrFalse, FillInTheBlanks,
   * @param question - Question to ask | String
   * @param answer | String
   */
  public Bean(
      Cluster cluster, String questionNum, QuestionType type, String question, String answer) {
    this.cluster = cluster;
    this.questionNum = questionNum;
    this.questionType = type;
    this.question = question;
    this.answer = answer;
  }

  public Long getId() {
    return id;
  }

  public String getQuestion() {
    return question;
  }

  public String getQuestionNum() {
    return questionNum;
  }

  public String getAnswer() {
    return answer;
  }

  public QuestionType getQuestionType() {
    return questionType;
  }

  public Cluster getCluster() {
    return cluster;
  }

  public Bean() {}
}
