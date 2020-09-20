package com.example.jpanplus1.controller;

import com.example.jpanplus1.dao.CatRepository;
import com.example.jpanplus1.dao.OwnerRepository;
import com.example.jpanplus1.entity.Owner;
import com.example.jpanplus1.entity.Cat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

/**
 * @author Incheol Jung
 */
@RestController
@RequestMapping(value = "/owners", produces = "application/json")
public class OwnerController {

    @Autowired
    CatRepository catRepository;

    @Autowired
    OwnerRepository ownerRepository;

    @Autowired
    EntityManager entityManager;

    @GetMapping
    public String get() {
        return "test";
    }
}
