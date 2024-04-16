package com.example.rest.Services;

import com.example.rest.DTO.TaskDTO;
import com.example.rest.Exceptions.ApiRequestException;
import com.example.rest.entities.Task;
import com.example.rest.entities.TaskStatus;

public interface TaskService {


    // para crea tareas
    Task createTask(long project_id, TaskDTO taskDTO);

    // para eliminar tareas
    void deleteTask(Long task_id);

    // para obtener tareas
    Task getTaskById(Long task_id);

    // para actualizar status
    Task updateTaskStatus(Long taskId, String newStatus) throws ApiRequestException;

    // Consultar tareas por fecha de vencimiento

//    Task getTaskByDueDate (dueDate ) {
//
//    }



}
