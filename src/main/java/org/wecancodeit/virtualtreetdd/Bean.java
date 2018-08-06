package org.wecancodeit.virtualtreetdd;

import java.util.Collection;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Bean {
  @Id @GeneratedValue private Long id;

  @ManyToOne private Cluster cluster;
  @ManyToOne private Lesson lesson;
  private String questionNum;
  private QuestionType questionType;
  @Lob private String question;
  @ElementCollection private Collection<String> answers;
  private String correctAnswer;

  protected enum QuestionType {
    Drag_n_Drop,
    FillInTheBlanks,
    MultipleChoice,
    TrueOrFalse,
  }

  /**
   * @param cluster - The 'Lesson' that the bean is attached to | Cluster DragNDrop, or
   *     MultipleChoice | QuestionType
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
      String questionNum,
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

  public String getQuestionNum() {
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

  public Bean() {}
}