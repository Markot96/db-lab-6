package com.markot.service;

import com.markot.domain.Story;
import com.markot.repository.StoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoryService implements AbstractService<Story, Integer> {

  private final StoryRepository storyRepository;

  public StoryService(StoryRepository storyRepository) {
    this.storyRepository = storyRepository;
  }

  @Override
  public List<Story> getAll() {
    return storyRepository.findAll();
  }

  @Override
  public Story getById(Integer id) {
    return storyRepository.getOne(id);
  }

  @Override
  public Story create(Story story) {
    return storyRepository.save(story);
  }

  @Override
  public Story update(Integer id, Story story) {
    if (storyRepository.findById(id).isPresent()) {
      return storyRepository.save(story);
    } else {
      return null;
    }
  }

  @Override
  public void deleteById(Integer id) {
    if (storyRepository.findById(id).isPresent()) {
      storyRepository.deleteById(id);
    }
  }
}
