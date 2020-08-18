package com.example.jpanplus1.controller;

import com.example.jpanplus1.dao.CatRepository;
import com.example.jpanplus1.dao.OwnerRepository;
import com.example.jpanplus1.entity.Cat;
import com.example.jpanplus1.entity.Owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.persistence.EntityManager;

/**
 * @author Incheol Jung
 */
@RestController
@RequestMapping(value = "/cats", produces = "application/json")
public class CatController {
    @Autowired
    CatRepository catRepository;

    @Autowired
    OwnerRepository ownerRepository;

    @Autowired
    EntityManager entityManager;

    @GetMapping
    public String get() {
        Owner owner1 = new Owner();
        owner1.setName("owner1");
        ownerRepository.save(owner1);

        Owner owner2 = new Owner();
        owner2.setName("owner2");
        ownerRepository.save(owner2);

        Owner owner3 = new Owner();
        owner3.setName("owner3");
        ownerRepository.save(owner3);

        Cat cat1 = new Cat();
        cat1.setName("cat1");
        cat1.setOwner(owner1);
        catRepository.save(cat1);

        Cat cat2 = new Cat();
        cat2.setName("cat2");
        cat2.setOwner(owner2);
        catRepository.save(cat2);

        Cat cat3 = new Cat();
        cat3.setName("cat3");
        cat3.setOwner(owner3);
        catRepository.save(cat3);

        Owner owner4 = new Owner();
        owner4.setName("owner4");
        ownerRepository.save(owner4);

        Owner owner5 = new Owner();
        owner5.setName("owner5");
        ownerRepository.save(owner5);

        Owner owner6 = new Owner();
        owner6.setName("owner6");
        ownerRepository.save(owner6);

        Cat cat4 = new Cat();
        cat4.setName("cat4");
        cat4.setOwner(owner4);
        catRepository.save(cat4);

        Cat cat5 = new Cat();
        cat5.setName("cat5");
        cat5.setOwner(owner5);
        catRepository.save(cat5);

        Cat cat6 = new Cat();
        cat3.setName("cat6");
        cat3.setOwner(owner6);
        catRepository.save(cat6);

        entityManager.clear();
        System.out.println("-------------------------------------------------------------------------------");
        List<Cat> cats = catRepository.findAll();

        return "test";
    }
}
