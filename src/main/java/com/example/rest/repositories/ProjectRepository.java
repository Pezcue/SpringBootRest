package com.example.rest.repositories;

import com.example.rest.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    Project findByName(String name);
    Project findProjectById(Long id);
}
