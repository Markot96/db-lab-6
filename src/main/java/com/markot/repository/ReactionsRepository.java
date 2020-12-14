package com.markot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.markot.domain.Reactions;

@Repository
public interface ReactionsRepository extends JpaRepository<Reactions, Integer> {
}
