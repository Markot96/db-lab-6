package com.markot.service;

import com.markot.repository.ReactionsRepository;
import org.springframework.stereotype.Service;
import com.markot.domain.Reactions;

import java.util.List;

@Service
public class ReactionsService implements AbstractService<Reactions, Integer> {

  private final ReactionsRepository reactionsRepository;

  public ReactionsService(ReactionsRepository reactionsRepository) {
    this.reactionsRepository = reactionsRepository;
  }

  @Override
  public List<Reactions> getAll() {
    return reactionsRepository.findAll();
  }

  @Override
  public Reactions getById(Integer id) {
    return reactionsRepository.getOne(id);
  }

  @Override
  public Reactions create(Reactions reactions) {
    return reactionsRepository.save(reactions);
  }

  @Override
  public Reactions update(Integer id, Reactions reactions) {
    if (reactionsRepository.findById(id).isPresent()) {
      return reactionsRepository.save(reactions);
    } else {
      return null;
    }
  }

  @Override
  public void deleteById(Integer id) {
    if (reactionsRepository.findById(id).isPresent()) {
      reactionsRepository.deleteById(id);
    }
  }
}
