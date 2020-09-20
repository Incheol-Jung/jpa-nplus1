package com.example.jpanplus1.dao;

import com.example.jpanplus1.entity.Cat;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Incheol Jung
 */
public interface CatRepository extends JpaRepository<Cat, Integer> {

}
