package com.example.rest.repositories;

import com.example.rest.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    Task findTaskById(Long id);
    List<Task> findByProjectId(Long projectId);

}
