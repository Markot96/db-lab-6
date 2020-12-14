package com.markot.dto;

public class UserDto {
  private Integer id;
  private String nickname;

  public UserDto(Integer id, String nickname) {
    this.id = id;
    this.nickname = nickname;
  }

  public UserDto(String nickname) {
    this.nickname = nickname;
  }

  public UserDto() {
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
}
