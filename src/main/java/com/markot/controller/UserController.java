package com.markot.controller;

import com.markot.domain.User;
import com.markot.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.markot.service.UserService;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/user")
@RestController
public class UserController {
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<UserDto>> getAll() {
    List<User> users = userService.getAll();
    List<UserDto> storyLineDtos = new ArrayList<>();
    for (User user : users) {
      UserDto userDto = new UserDto(
          user.getId(),
          user.getNickname()
      );
      storyLineDtos.add(userDto);
    }
    return new ResponseEntity<>(storyLineDtos, HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public ResponseEntity<UserDto> getById(@PathVariable Integer id) {
    User user = userService.getById(id);
    if (user != null) {
      UserDto storyLineDto = new UserDto(
          user.getId(),
          user.getNickname()
      );
      return new ResponseEntity<>(storyLineDto, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<Void> create(@RequestBody User newUser) {
    userService.create(newUser);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @RequestMapping(method = RequestMethod.PUT,
      value = "/{id}",
      consumes = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<UserDto> update(@PathVariable Integer id,
                                             @RequestBody User user) {
    User userOld = userService.getById(id);
    System.out.println(userOld);

    if (userOld != null) {
      user.setId(id);
      userService.update(id, user);
      UserDto pilotOldDto = new UserDto(
          userOld.getId(),
          userOld.getNickname()
      );
      return new ResponseEntity<>(pilotOldDto, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
    if (userService.getById(id) != null) {
      userService.deleteById(id);
      return new ResponseEntity<>(HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}
