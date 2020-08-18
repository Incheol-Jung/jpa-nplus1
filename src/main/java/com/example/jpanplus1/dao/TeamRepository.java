package com.example.jpanplus1.dao;

import com.example.jpanplus1.entity.Team;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Incheol Jung
 */
public interface TeamRepository extends JpaRepository<Team, Integer> {
    @Query("select t from Team t")
    List<Team> findAll();
}
