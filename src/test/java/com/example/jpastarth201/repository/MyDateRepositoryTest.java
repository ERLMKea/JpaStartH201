package com.example.jpastarth201.repository;

import com.example.jpastarth201.model.MyDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MyDateRepositoryTest {

    @Autowired
    MyDateRepository myDateRepository;

    @BeforeEach
    void setUp() {
        MyDate md1 = new MyDate();
        md1.setBorn(LocalDate.now());
        myDateRepository.save(md1);
    }

    @Test
    void name() {
        List<MyDate> lst = myDateRepository.findAll();
        assertEquals(1, lst.size());
    }
}