package com.example.rest.Services;

import com.example.rest.DTO.TaskDTO;
import com.example.rest.entities.Task;

public interface TaskService {


    // para crea tareas

    Task createTask(long project_id, TaskDTO taskDTO);

    // para eliminar tareas

    void deleteTask(Long task_id);

    // para obtener tareas

    Task getTaskById(Long task_id);

}
