package com.markot.service;

import com.markot.repository.PasswordRepository;
import org.springframework.stereotype.Service;
import com.markot.domain.Password;

import java.util.List;

@Service
public class PasswordService implements AbstractService<Password, Integer> {

  private final PasswordRepository passwordRepository;

  public PasswordService(PasswordRepository passwordRepository) {
    this.passwordRepository = passwordRepository;
  }

  @Override
  public List<Password> getAll() {
    return passwordRepository.findAll();
  }

  @Override
  public Password getById(Integer id) {
    return passwordRepository.getOne(id);
  }

  @Override
  public Password create(Password password) {
    return passwordRepository.save(password);
  }

  @Override
  public Password update(Integer id, Password password) {
    if (passwordRepository.findById(id).isPresent()) {
      return passwordRepository.save(password);
    } else {
      return null;
    }
  }

  @Override
  public void deleteById(Integer id) {
    if (passwordRepository.findById(id).isPresent()) {
      passwordRepository.deleteById(id);
    }
  }
}
