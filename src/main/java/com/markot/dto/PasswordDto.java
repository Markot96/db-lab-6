package com.markot.dto;

public class PasswordDto {
  private Integer id;
  private String password;
  private Integer userId;

  public PasswordDto(Integer id, String password, Integer userId) {
    this.id = id;
    this.password = password;
    this.userId = userId;
  }

  public PasswordDto(String password, Integer userId) {
    this.password = password;
    this.userId = userId;
  }

  public PasswordDto() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }
}
