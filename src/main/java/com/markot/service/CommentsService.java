package com.markot.service;

import com.markot.domain.Comments;
import com.markot.repository.CommentsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsService implements AbstractService<Comments, Integer> {

  private final CommentsRepository commentsRepository;

  public CommentsService(CommentsRepository commentsRepository) {
    this.commentsRepository = commentsRepository;
  }

  @Override
  public List<Comments> getAll() {
    return commentsRepository.findAll();
  }

  @Override
  public Comments getById(Integer id) {
    return commentsRepository.getOne(id);
  }

  @Override
  public Comments create(Comments comment) {
    return commentsRepository.save(comment);
  }

  @Override
  public Comments update(Integer id, Comments comment) {
    if (commentsRepository.findById(id).isPresent()) {
      return commentsRepository.save(comment);
    } else {
      return null;
    }

  }

  @Override
  public void deleteById(Integer id) {
    if (commentsRepository.findById(id).isPresent()) {
      commentsRepository.deleteById(id);
    }

  }
}
