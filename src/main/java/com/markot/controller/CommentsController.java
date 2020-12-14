package com.markot.controller;

import com.markot.domain.Comments;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.markot.dto.CommentsDto;
import com.markot.service.CommentsService;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/comments")
@RestController
public class CommentsController {
  private final CommentsService commentService;

  public CommentsController(CommentsService commentService) {
    this.commentService = commentService;
  }

  @RequestMapping(method = RequestMethod.GET)

  public ResponseEntity<List<CommentsDto>> getAll() {
    List<Comments> comments = commentService.getAll();
    List<CommentsDto> commentDtos = new ArrayList<>();
    for (Comments comment : comments) {
      CommentsDto commentDto = new CommentsDto(
              comment.getId(),
              comment.getAuthor(),
              comment.getText(),
              comment.getAmountOfLikes(),
              comment.getWritingTime()
      );
      commentDtos.add(commentDto);
    }
    return new ResponseEntity<>(commentDtos, HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public ResponseEntity<CommentsDto> getById(@PathVariable Integer id) {
    Comments comment = commentService.getById(id);
    if (comment != null) {
      CommentsDto commentDto = new CommentsDto(
              comment.getId(),
              comment.getAuthor(),
              comment.getText(),
              comment.getAmountOfLikes(),
              comment.getWritingTime()
      );
      return new ResponseEntity<>(commentDto, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<Void> create(@RequestBody Comments newComments) {
    commentService.create(newComments);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @RequestMapping(method = RequestMethod.PUT,
      value = "/{id}",
      consumes = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<CommentsDto> update(@PathVariable Integer id,
                                            @RequestBody Comments comment) {
    Comments commentOld = commentService.getById(id);
    if (commentOld != null) {
      comment.setId(id);
      commentService.update(id, comment);
      CommentsDto commentOldDto = new CommentsDto(
              commentOld.getId(),
              commentOld.getAuthor(),
              commentOld.getText(),
              commentOld.getAmountOfLikes(),
              commentOld.getWritingTime()
      );
      return new ResponseEntity<>(commentOldDto, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
    if (commentService.getById(id) != null) {
      commentService.deleteById(id);
      return new ResponseEntity<>(HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }


}
