package com.example.jpanplus1.service;

import com.example.jpanplus1.dao.TeamRepository;
import com.example.jpanplus1.entity.Member;
import com.example.jpanplus1.entity.Team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Incheol Jung
 */
@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public Team getOne(Integer id) {
        return teamRepository.findById(id)
            .orElse(null);
    }

    public Team add(Team team) {
        return teamRepository.save(team);
    }

    public Team update(Integer id, List<Member> members) {
        Team team = teamRepository.findById(id).orElse(null);
        team.setMembers(members);
        return teamRepository.save(team);
    }
}
