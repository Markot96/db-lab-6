package com.markot.service;

import com.markot.domain.StoryLine;
import com.markot.repository.StoryLineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoryLineService implements AbstractService<StoryLine, Integer> {

  private final StoryLineRepository storyLineRepository;

  public StoryLineService(StoryLineRepository storyLineRepository) {
    this.storyLineRepository = storyLineRepository;
  }

  @Override
  public List<StoryLine> getAll() {
    return storyLineRepository.findAll();
  }

  @Override
  public StoryLine getById(Integer userId) {
    return storyLineRepository.getOne(userId);
  }

  @Override
  public StoryLine create(StoryLine storyLine) {
    return storyLineRepository.save(storyLine);
  }

  @Override
  public StoryLine update(Integer userId, StoryLine storyLine) {
    if (storyLineRepository.findById(userId).isPresent()) {
      return storyLineRepository.save(storyLine);
    } else {
      return null;
    }
  }

  @Override
  public void deleteById(Integer userId) {
    if (storyLineRepository.findById(userId).isPresent()) {
      storyLineRepository.deleteById(userId);
    }
  }
}
