package com.markot.controller;

import com.markot.domain.StoryLine;
import com.markot.dto.StoryLineDto;
import com.markot.service.StoryLineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/story_line")
@RestController
public class StoryLineController {
    private final StoryLineService storyLineService;

    public StoryLineController(StoryLineService storyLineService) {
        this.storyLineService = storyLineService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<StoryLineDto>> getAll() {
        List<StoryLine> storyLines = storyLineService.getAll();
        List<StoryLineDto> storyLineDtos = new ArrayList<>();
        for (StoryLine storyLine : storyLines) {
            StoryLineDto storyLineDto = new StoryLineDto(
                    storyLine.getUserId(),
                    storyLine.getStoryAuthor(),
                    storyLine.getWatchedStatus()
            );
            storyLineDtos.add(storyLineDto);
        }
        return new ResponseEntity<>(storyLineDtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<StoryLineDto> getById(@PathVariable Integer userId) {
        StoryLine storyLine = storyLineService.getById(userId);
        if (storyLine != null) {
            StoryLineDto storyLineDto = new StoryLineDto(
                    storyLine.getUserId(),
                    storyLine.getStoryAuthor(),
                    storyLine.getWatchedStatus()
            );
            return new ResponseEntity<>(storyLineDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> create(@RequestBody StoryLine newStoryLine) {
        storyLineService.create(newStoryLine);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT,
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<StoryLineDto> update(@PathVariable Integer userId,
                                           @RequestBody StoryLine storyLine) {
        StoryLine storyLineOld = storyLineService.getById(userId);
        if (storyLineOld != null) {
            storyLineService.update(userId, storyLine);
            StoryLineDto storyLineOldDto = new StoryLineDto(
                    storyLineOld.getUserId(),
                    storyLineOld.getStoryAuthor(),
                    storyLineOld.getWatchedStatus()
            );
            return new ResponseEntity<>(storyLineOldDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer userId) {
        if (storyLineService.getById(userId) != null) {
            storyLineService.deleteById(userId);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
