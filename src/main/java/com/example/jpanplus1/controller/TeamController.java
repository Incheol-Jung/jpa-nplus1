package com.example.jpanplus1.controller;

import com.example.jpanplus1.entity.Member;
import com.example.jpanplus1.entity.Team;
import com.example.jpanplus1.service.MemberSerivce;
import com.example.jpanplus1.service.TeamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Incheol Jung
 */
@RestController
@RequestMapping(value = "/teams", produces = "application/json")
public class TeamController {
    @Autowired
    private TeamService teamService;

    @Autowired
    private MemberSerivce memberSerivce;

    @GetMapping("/{id}")
    public Team getOne(@PathVariable Integer id){
        return teamService.getOne(id);
    }

    @PostMapping
    public Team add(@RequestBody Team team){
        return teamService.add(team);
    }

    @PutMapping("/{id}")
    public Team update(@PathVariable Integer id) {
        List<Member> members = memberSerivce.get();
        return teamService.update(id, members);
    }
}
