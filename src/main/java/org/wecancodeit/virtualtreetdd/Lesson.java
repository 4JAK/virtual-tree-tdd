package org.wecancodeit.virtualtreetdd;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Lesson {
  @Id @GeneratedValue private Long id;

  @Lob private String example;
  private String image;

  @JsonIgnore
  @OneToMany(mappedBy = "lesson")
  private Collection<Bean> beans;

  /**
   * @param example - Paragraph of text
   * @param images - A list of images | String
   * @param beans - List of beans connection to lesson. May include only 1 Bean.
   */
  public Lesson(String example, String image) {
    this.example = example;
    this.image = image;
  }

  @Override
  public String toString() {
    return "Lesson [id=" + id + ",\nexample=" + example + ",\nimage=" + image + "]";
  }

  public Long getId() {
    return id;
  }

  public String getExample() {
    return example;
  }

  public String getImage() {
    return image;
  }

  public Collection<Bean> getBeans() {
    return beans;
  }

  public Lesson() {}
}
