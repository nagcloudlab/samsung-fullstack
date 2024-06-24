package com.example.repository;

import com.example.entity.Boy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoyRepository extends JpaRepository<Boy,Integer> {

//    @Query("from Boy where name = ?1") //  JPQL
    List<Boy> findByName(String name);

}
