package com.markot.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "comments")
public class Comments {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @Column(name = "author")
  private String author;

  @Column(name = "text")
  private String text;

  @Column(name = "amount_of_likes")
  private Integer amountOfLikes;

  @Column(name = "writing_time")
  private Integer writingTime;

  public Comments(Integer id, String author, String text, Integer amountOfLikes, Integer writingTime) {
    this.id = id;
    this.author = author;
    this.text = text;
    this.amountOfLikes = amountOfLikes;
    this.writingTime = writingTime;
  }

  public Comments(String author, String text, Integer amountOfLikes, Integer writingTime) {
    this(null, author, text, amountOfLikes, writingTime);
  }
  public Comments() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Integer getAmountOfLikes() {
    return amountOfLikes;
  }

  public void setAmountOfLikes(Integer amountOfLikes) {
    this.amountOfLikes = amountOfLikes;
  }

  public Integer getWritingTime() {
    return writingTime;
  }

  public void setWritingTime(Integer writingTime) {
    this.writingTime = writingTime;
  }

  @Override
  public String toString() {
    return "Comments{" +
            "id=" + id +
            ", author='" + author + '\'' +
            ", text='" + text + '\'' +
            ", amountOfLikes=" + amountOfLikes +
            ", writingTime=" + writingTime +
            '}';
  }
}
