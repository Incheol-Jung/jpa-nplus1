package com.example.jpanplus1.service;

import com.example.jpanplus1.dao.MemberRepository;
import com.example.jpanplus1.entity.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Incheol Jung
 */
@Service
public class MemberSerivce {
    @Autowired
    MemberRepository memberRepository;

    public Member add(Member member) {
        return memberRepository.save(member);
    }

    public List<Member> get() {
        return memberRepository.findAll();
    }
}
