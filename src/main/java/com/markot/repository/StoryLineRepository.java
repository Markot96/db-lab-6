package com.markot.repository;

import com.markot.domain.StoryLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoryLineRepository extends JpaRepository<StoryLine, Integer> {
}
