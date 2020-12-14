package com.markot.dto;

public class StoryLineDto {
  private Integer userId;
  private String storyAuthor;
  private Integer watchedStatus;

  public StoryLineDto(Integer userId, String storyAuthor, Integer watchedStatus) {
    this.userId = userId;
    this.storyAuthor = storyAuthor;
    this.watchedStatus = watchedStatus;
  }

  public StoryLineDto(String storyAuthor, Integer watchedStatus) {
    this.storyAuthor = storyAuthor;
    this.watchedStatus = watchedStatus;
  }

  public StoryLineDto() {
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public String getStoryAuthor() {
    return storyAuthor;
  }

  public void setStoryAuthor(String storyAuthor) {
    this.storyAuthor = storyAuthor;
  }

  public Integer getWatchedStatus() {
    return watchedStatus;
  }

  public void setWatchedStatus(Integer watchedStatus) {
    this.watchedStatus = watchedStatus;
  }
}
