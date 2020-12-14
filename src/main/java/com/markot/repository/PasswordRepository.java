package com.markot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.markot.domain.Password;

@Repository
public interface PasswordRepository extends JpaRepository<Password, Integer> {
}
