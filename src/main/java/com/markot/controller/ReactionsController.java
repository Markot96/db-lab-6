package com.markot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.markot.domain.Reactions;
import com.markot.dto.ReactionsDto;
import com.markot.service.ReactionsService;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/reactions")
@RestController
public class ReactionsController {
  private final ReactionsService reactionsService;

  public ReactionsController(ReactionsService reactionsService) {
    this.reactionsService = reactionsService;
  }

  @RequestMapping(method = RequestMethod.GET)

  public ResponseEntity<List<ReactionsDto>> getAll() {
    List<Reactions> reactions = reactionsService.getAll();
    List<ReactionsDto> reactionsDtos = new ArrayList<>();
    for (Reactions reaction : reactions) {
      ReactionsDto reactionsDto = new ReactionsDto(
          reaction.getId(),
          reaction.getAmountOfViews(),
          reaction.getAmountOfEmojis()
      );
      reactionsDtos.add(reactionsDto);
    }
    return new ResponseEntity<>(reactionsDtos, HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public ResponseEntity<ReactionsDto> getById(@PathVariable Integer id) {
    Reactions reaction = reactionsService.getById(id);
    if (reaction != null) {
      ReactionsDto reactionsDto = new ReactionsDto(
          reaction.getId(),
          reaction.getAmountOfViews(),
          reaction.getAmountOfEmojis()
      );
      return new ResponseEntity<>(reactionsDto, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<Void> create(@RequestBody Reactions newReactions) {
    reactionsService.create(newReactions);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @RequestMapping(method = RequestMethod.PUT,
      value = "/{id}",
      consumes = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<ReactionsDto> update(@PathVariable Integer id,
                                        @RequestBody Reactions reactions) {
    Reactions reactionsOld = reactionsService.getById(id);
    if (reactionsOld != null) {
      reactionsService.update(id, reactions);
      ReactionsDto reactionsOldDto = new ReactionsDto(
          reactionsOld.getId(),
          reactionsOld.getAmountOfViews(),
          reactionsOld.getAmountOfEmojis()
      );
      return new ResponseEntity<>(reactionsOldDto, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
    if (reactionsService.getById(id) != null) {
      reactionsService.deleteById(id);
      return new ResponseEntity<>(HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}
