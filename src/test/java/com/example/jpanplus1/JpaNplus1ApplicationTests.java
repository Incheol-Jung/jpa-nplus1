package com.example.jpanplus1;

import com.example.jpanplus1.dao.CatRepository;
import com.example.jpanplus1.dao.OwnerRepository;
import com.example.jpanplus1.entity.Cat;
import com.example.jpanplus1.entity.Owner;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class JpaNplus1ApplicationTests {

    @Autowired
    CatRepository catRepository;

    @Autowired
    OwnerRepository ownerRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    @Transactional
    @Commit
    void exampleTest() {
        Set<Cat> cats = new LinkedHashSet<>();
        for(int i = 0; i < 10; i++){
            cats.add(new Cat("cat" + i));
        }
        catRepository.saveAll(cats);

        List<Owner> owners = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            Owner owner = new Owner("owner" + i);
            owner.setCats(cats);
            owners.add(owner);
        }
        ownerRepository.saveAll(owners);

        entityManager.clear();
        System.out.println("-------------------------------------------------------------------------------");
        List<Owner> everyOwners = ownerRepository.findAll();
        assertFalse(everyOwners.isEmpty());
    }

}
