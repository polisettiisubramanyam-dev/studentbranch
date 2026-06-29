package com.site.studentbranch.repository;

import com.site.studentbranch.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

}
