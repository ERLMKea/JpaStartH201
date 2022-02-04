package com.example.jpastarth201.config;

import com.example.jpastarth201.model.MyDate;
import com.example.jpastarth201.repository.MyDateRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class StartAndSave implements CommandLineRunner {

    MyDateRepository myDateRepository;

    public StartAndSave(MyDateRepository myDateRepository) {
        this.myDateRepository = myDateRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        MyDate md1 = new MyDate();
        md1.setBorn(LocalDate.now());
        myDateRepository.save(md1);
        //md1.setBorn(md1.getBorn().plusDays(1));
        md1 = new MyDate();
        md1.setBorn(LocalDate.now().plusDays(1));
        myDateRepository.save(md1);
    }
}
