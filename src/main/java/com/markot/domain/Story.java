package com.markot.domain;

import javax.persistence.*;

@Entity
@Table(name = "story")
public class Story {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @Column(name = "type_of_story")
  private Integer typeOfStory;

  @Column(name = "file_name")
  private String fileName;

  @Column(name = "upload_time")
  private String uploadTime;

  @Column(name = "file_size_in_mb")
  private Integer fileSizeInMb;

  @Column(name = "duration_in_seconds")
  private Integer durationInSeconds;

  @ManyToOne
  @JoinColumn(name = "story_line_user_id", referencedColumnName = "user_id", nullable = false)
  private StoryLine storyLineUserId;

  @Column(name = "comments_id")
  private Integer commentsId;

  @Column(name = "reactions_id")
  private Integer reactionsId;


  public Story(Integer id, Integer typeOfStory, String fileName, String uploadTime, Integer fileSizeInMb, Integer durationInSeconds, StoryLine storyLineUserId, Integer commentsId, Integer reactionsId) {
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


  public Story(Integer typeOfStory, String fileName, String uploadTime, Integer fileSizeInMb, Integer durationInSeconds, StoryLine storyLineUserId, Integer commentsId, Integer reactionsId) {
    this(null, typeOfStory, fileName, uploadTime, fileSizeInMb, null, storyLineUserId, commentsId, reactionsId);
  }

  public Story() {

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

  public StoryLine getStoryLineUserId() {
    return storyLineUserId;
  }

  public void setStoryLineUserId(StoryLine storyLineUserId) {
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

  @Override
  public String toString() {
    return "Story{" +
            "id=" + id +
            ", typeOfStory=" + typeOfStory +
            ", fileName='" + fileName + '\'' +
            ", uploadTime='" + uploadTime + '\'' +
            ", fileSizeInMb=" + fileSizeInMb +
            ", durationInSeconds=" + durationInSeconds +
            ", storyLineUserId=" + storyLineUserId +
            ", commentsId=" + commentsId +
            ", reactionsId=" + reactionsId +
            '}';
  }
}
