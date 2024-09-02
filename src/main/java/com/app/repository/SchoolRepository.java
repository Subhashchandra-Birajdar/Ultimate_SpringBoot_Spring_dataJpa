package com.app.repository;

import com.app.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SchoolRepository extends JpaRepository<School,Integer> {
    List<School> findAllByschoolnameContaining(String sname);
}
