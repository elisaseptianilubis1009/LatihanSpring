package com.springboot.elisa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.elisa.model.Position;

public interface PositionRepository extends JpaRepository<Position, Long> {

}
