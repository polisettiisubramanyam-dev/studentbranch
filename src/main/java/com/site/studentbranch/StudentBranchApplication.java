package com.site.studentbranch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class StudentBranchApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentBranchApplication.class, args);
    }

}
