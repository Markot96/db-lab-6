package com.markot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.markot.domain.Password;
import com.markot.dto.PasswordDto;
import com.markot.service.PasswordService;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/password")
@RestController
public class PasswordController {
  private final PasswordService passwordService;

  public PasswordController(PasswordService passwordService) {
    this.passwordService = passwordService;
  }

  @RequestMapping(method = RequestMethod.GET)

  public ResponseEntity<List<PasswordDto>> getAll() {
    List<Password> passwords = passwordService.getAll();
    List<PasswordDto> passwordDtos = new ArrayList<>();
    for (Password password : passwords) {
      PasswordDto passwordDto = new PasswordDto(
          password.getId(),
          password.getPassword(),
          password.getUserId()
      );
      passwordDtos.add(passwordDto);
    }
    return new ResponseEntity<>(passwordDtos, HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public ResponseEntity<PasswordDto> getById(@PathVariable Integer id) {
    Password passwordOld = passwordService.getById(id);
    if (passwordOld != null) {
      PasswordDto passwordDto = new PasswordDto(
          passwordOld.getId(),
          passwordOld.getPassword(),
          passwordOld.getUserId()
      );
      return new ResponseEntity<>(passwordDto, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<Void> create(@RequestBody Password newPassword) {
    passwordService.create(newPassword);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @RequestMapping(method = RequestMethod.PUT,
      value = "/{id}",
      consumes = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<PasswordDto> update(@PathVariable Integer id,
                                            @RequestBody Password password) {
    Password passwordOld = passwordService.getById(id);
    if (passwordOld != null) {
      passwordService.update(id, password);
      PasswordDto passwordOldDto = new PasswordDto(
          password.getId(),
          password.getPassword(),
          password.getUserId()
      );
      return new ResponseEntity<>(passwordOldDto, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
    if (passwordService.getById(id) != null) {
      passwordService.deleteById(id);
      return new ResponseEntity<>(HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}
