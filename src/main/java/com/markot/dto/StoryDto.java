package com.markot.dto;

import com.markot.domain.StoryLine;

public class StoryDto {
  private Integer id;
  private Integer typeOfStory;
  private String fileName;
  private String uploadTime;
  private Integer fileSizeInMb;
  private Integer durationInSeconds;
  private Integer storyLineUserId;
  private Integer commentsId;
  private Integer reactionsId;

  public StoryDto(Integer id, Integer typeOfStory, String fileName, String uploadTime, Integer fileSizeInMb, Integer durationInSeconds, Integer storyLineUserId, Integer commentsId, Integer reactionsId) {
    this.id = id;
    this.typeOfStory = typeOfStory;
    this.fileName = fileName;
    this.uploadTime = uploadTime;
    this.fileSizeInMb = fileSizeInMb;
    this.durationInSeconds = durationInSeconds;
    this.storyLineUserId = storyLineUserId;
    this.commentsId = commentsId;
    this.reactionsId = reactionsId;
  }

  public StoryDto(Integer typeOfStory, String fileName, String uploadTime, Integer fileSizeInMb, Integer durationInSeconds, Integer storyLineUserId, Integer commentsId, Integer reactionsId) {
    this.typeOfStory = typeOfStory;
    this.fileName = fileName;
    this.uploadTime = uploadTime;
    this.fileSizeInMb = fileSizeInMb;
    this.durationInSeconds = durationInSeconds;
    this.storyLineUserId = storyLineUserId;
    this.commentsId = commentsId;
    this.reactionsId = reactionsId;
  }

  public StoryDto() {
  }

    public StoryDto(Integer id, Integer typeOfStory, String fileName, String uploadTime, Integer fileSizeInMb, Integer durationInSeconds, StoryLine storyLineUserId, Integer commentsId, Integer reactionsId) {
    }

    public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getTypeOfStory() {
    return typeOfStory;
  }

  public void setTypeOfStory(Integer typeOfStory) {
    this.typeOfStory = typeOfStory;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public String getUploadTime() {
    return uploadTime;
  }

  public void setUploadTime(String uploadTime) {
    this.uploadTime = uploadTime;
  }

  public Integer getFileSizeInMb() {
    return fileSizeInMb;
  }

  public void setFileSizeInMb(Integer fileSizeInMb) {
    this.fileSizeInMb = fileSizeInMb;
  }

  public Integer getDurationInSeconds() {
    return durationInSeconds;
  }

  public void setDurationInSeconds(Integer durationInSeconds) {
    this.durationInSeconds = durationInSeconds;
  }

  public Integer getStoryLineUserId() {
    return storyLineUserId;
  }

  public void setStoryLineUserId(Integer storyLineUserId) {
    this.storyLineUserId = storyLineUserId;
  }

  public Integer getCommentsId() {
    return commentsId;
  }

  public void setCommentsId(Integer commentsId) {
    this.commentsId = commentsId;
  }

  public Integer getReactionsId() {
    return reactionsId;
  }

  public void setReactionsId(Integer reactionsId) {
    this.reactionsId = reactionsId;
  }
}
