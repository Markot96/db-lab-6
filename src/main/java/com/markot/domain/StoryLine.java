package com.markot.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "story_line")
public class StoryLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer UserId;

    @Column(name = "story_author")
    private String storyAuthor;

    @Column(name = "watched_status")
    private Integer watchedStatus;

    @OneToMany(mappedBy = "storyLineUserId", fetch = FetchType.EAGER)
    private Set<Story> story;

    public StoryLine(Integer userId, String storyAuthor, Integer watchedStatus) {
        UserId = userId;
        this.storyAuthor = storyAuthor;
        this.watchedStatus = watchedStatus;
    }

    public StoryLine(String story_author, Integer watchedStatus) {
        this(null, story_author, watchedStatus);
    }

    public StoryLine() {}

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer userId) {
        UserId = userId;
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

    @Override
    public String toString() {
        return "StoryLine{" +
                "UserId=" + UserId +
                ", storyAuthor='" + storyAuthor + '\'' +
                ", watchedStatus=" + watchedStatus +
                ", story=" + story +
                '}';
    }
}
