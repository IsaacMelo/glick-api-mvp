package com.glick.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glick.api.model.Score;

public interface ScoreRepository extends JpaRepository<Score, Long>{

}
