package com.example.rest.repositories;

import com.example.rest.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    Task findTaskById(Long id);
    List<Task> findByProjectId(Long projectId);

    List<Task> findByProjectIdAndDueDateBefore(Long projectId, LocalDate currentDate);

}
