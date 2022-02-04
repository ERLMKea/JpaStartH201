package com.example.jpastarth201.repository;

import com.example.jpastarth201.model.MyDate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyDateRepository extends JpaRepository<MyDate, Integer> {

}
