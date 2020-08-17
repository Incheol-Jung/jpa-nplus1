package com.example.jpanplus1.dao;

import com.example.jpanplus1.entity.Team;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Incheol Jung
 */
public interface TeamRepository extends JpaRepository<Team, Integer> {
//    Team findById(Integer id);
}
