package com.example.jpanplus1.controller;

import com.example.jpanplus1.entity.Member;
import com.example.jpanplus1.service.MemberSerivce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Incheol Jung
 */
@RestController
@RequestMapping(value = "/members", produces = "application/json")
public class MemberController {
    @Autowired
    MemberSerivce memberSerivce;

    @PostMapping
    public Member add(@RequestBody Member member){
        return memberSerivce.add(member);
    }
}
