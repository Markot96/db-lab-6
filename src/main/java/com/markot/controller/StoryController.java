package com.markot.controller;

import com.markot.domain.Story;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.markot.dto.StoryDto;
import com.markot.service.StoryService;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/story")
@RestController
public class StoryController {
    private final StoryService storyService;

    public StoryController(StoryService storyService) {
        this.storyService = storyService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<StoryDto>> getAll() {
        List<Story> stories = storyService.getAll();
        List<StoryDto> storyDtos = new ArrayList<>();
        for (Story story : stories) {
            StoryDto storyDto = new StoryDto(
                    story.getId(),
                    story.getTypeOfStory(),
                    story.getFileName(),
                    story.getUploadTime(),
                    story.getFileSizeInMb(),
                    story.getDurationInSeconds(),
                    story.getStoryLineUserId(),
                    story.getCommentsId(),
                    story.getReactionsId()
            );
            storyDtos.add(storyDto);
        }
        return new ResponseEntity<>(storyDtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<StoryDto> getById(@PathVariable Integer id) {
        Story story = storyService.getById(id);
        if (story != null) {
            StoryDto storyDto = new StoryDto(
                    story.getId(),
                    story.getTypeOfStory(),
                    story.getFileName(),
                    story.getUploadTime(),
                    story.getFileSizeInMb(),
                    story.getDurationInSeconds(),
                    story.getStoryLineUserId(),
                    story.getCommentsId(),
                    story.getReactionsId()
            );
            return new ResponseEntity<>(storyDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> create(@RequestBody Story newStory) {
        storyService.create(newStory);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT,
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<StoryDto> update(@PathVariable Integer id,
                                           @RequestBody Story story) {
        Story storyOld = storyService.getById(id);
        if (storyOld != null) {
            storyService.update(id, story);
            StoryDto flightOldDto = new StoryDto(
                    storyOld.getId(),
                    storyOld.getTypeOfStory(),
                    storyOld.getFileName(),
                    storyOld.getUploadTime(),
                    storyOld.getFileSizeInMb(),
                    storyOld.getDurationInSeconds(),
                    storyOld.getStoryLineUserId(),
                    storyOld.getCommentsId(),
                    storyOld.getReactionsId()
            );
            return new ResponseEntity<>(flightOldDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        if (storyService.getById(id) != null) {
            storyService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
