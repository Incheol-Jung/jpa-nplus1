package com.example.jpanplus1.dao;

import com.example.jpanplus1.entity.Member;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Incheol Jung
 */
public interface MemberRepository extends JpaRepository<Member, Integer> {}
