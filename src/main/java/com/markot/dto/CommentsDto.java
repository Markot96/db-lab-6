package com.markot.dto;

public class CommentsDto {
  private Integer id;

  private String author;

  private String text;

  private Integer amountOfLikes;

  private String writingTime;

  public CommentsDto(Integer id, String author, String text, Integer amountOfLikes, String writingTime) {
    this.id = id;
    this.author = author;
    this.text = text;
    this.amountOfLikes = amountOfLikes;
    this.writingTime = writingTime;
  }

  public CommentsDto(String author, String text, Integer amountOfLikes, String writingTime) {
    this.author = author;
    this.text = text;
    this.amountOfLikes = amountOfLikes;
    this.writingTime = writingTime;
  }

  public CommentsDto() { }

  public CommentsDto(Integer id, String author, String text, Integer amountOfLikes, Integer writingTime) {
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

  public String getWritingTime() {
    return writingTime;
  }

  public void setWritingTime(String writingTime) {
    this.writingTime = writingTime;
  }
}
