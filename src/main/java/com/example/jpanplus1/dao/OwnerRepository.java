package com.example.jpanplus1.dao;

import com.example.jpanplus1.entity.Owner;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Incheol Jung
 */
public interface OwnerRepository extends JpaRepository<Owner, Integer> {
    @Query("select o from Owner o join fetch o.cats")
    List<Owner> findAllJoinFetch();

    @Query(
        value = "select c from Owner c join fetch c.cats",
        countQuery = "select count(c) from Owner c"
    )
    Page<Owner> findAllJoinFetchPaging(Pageable pageable);

    @Query("select c from Owner c join c.cats")
    List<Owner> findAllJoin();

    @EntityGraph(attributePaths = "cats")
    @Query("select o from Owner o")
    List<Owner> findAllEntityGraph();
}
