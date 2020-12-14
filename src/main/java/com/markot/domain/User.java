package com.markot.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @Column(name = "nickname")
  private String nickname;


  public User(Integer id, String nickname) {
    this.id = id;
    this.nickname = nickname;
  }

  public User(String nickname) {
    this(null, nickname);
  }

  public User() {

  }


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", nickname='" + nickname + '\'' +
            '}';
  }
}
