package com.example.jpanplus1.service;

import com.example.jpanplus1.dao.MemberRepository;
import com.example.jpanplus1.dao.TeamRepository;
import com.example.jpanplus1.entity.Member;
import com.example.jpanplus1.entity.Team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

/**
 * @author Incheol Jung
 */
@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private MemberRepository memberRepository;

    public List<Team> get() {
        List<Team> teams = teamRepository.findAll();
        List<String> names = teams.stream().flatMap(a -> a.getMembers().stream().map(s -> s.getName())).collect(Collectors.toList());
        System.out.println(names.toString());

        return teams;
    }

    public Team getOne(Integer id) {
        return teamRepository.findById(id)
            .orElse(null);
    }

    public Team add(Team team) {
        return teamRepository.save(team);
    }

    @Transactional
    public Team update(Integer id) {
        Team team = teamRepository.findById(id).orElse(null);
        List<Member> members = memberRepository.findAll();

        for (Member member : members) {
            team.getMembers().add(member);
            member.setTeam(team);
        }
        return team;
    }
}
