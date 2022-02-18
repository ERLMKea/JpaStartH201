package com.example.jpastarth201.repository;

import com.example.jpastarth201.model.MyDate;
import org.hibernate.dialect.Ingres9Dialect;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

        for (int i=0; i<10; i++) {
            md1 = new MyDate();
            md1.setBorn(LocalDate.now().plusDays(1));
            myDateRepository.save(md1);
            System.out.println(myDateRepository.findAll().size());
        }

    }

    @Test
    void name() {
        List<MyDate> lst = myDateRepository.findAll();
        assertEquals(1, lst.size());
    }

    @Test
    void myMapTest() {
        List<MyDate> lst = myDateRepository.findAll();
        System.out.println("yyyyyyyy size=" + lst.size());
        Stream<LocalDate> darr = lst.stream().map(a -> a.getBorn());
        darr.forEach(a -> System.out.println("xxxxxxxxx" + a));
    }

    @Test
    void testEqualDate() {
        List<MyDate> lst = myDateRepository.findAll();
        System.out.println(lst.size());
        Predicate<Integer> getEqual = i -> i % 2 == 0;
        IntStream inst = lst.stream().mapToInt(d -> d.getBorn().getDayOfWeek().getValue());
        //inst.filter()
        //System.out.;
    }
}



