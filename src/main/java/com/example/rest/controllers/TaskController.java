package com.example.rest.controllers;

import com.example.rest.DTO.TaskDTO;
import com.example.rest.Exceptions.ApiRequestException;
import com.example.rest.Services.TaskServiceImpl;
import com.example.rest.entities.Task;
import com.example.rest.entities.TaskStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Map;

@RestController
@RequestMapping("/v1/task/")
public class TaskController {

    //Injeccion del servicio para Task

    private TaskServiceImpl taskService;

    public TaskController(TaskServiceImpl taskService) {
        this.taskService = taskService;
    }

    // POST // Crear tarea
    @PostMapping("/project/{id}")
    public ResponseEntity<Task> createTask(@PathVariable("id") Long project_id, @RequestBody TaskDTO taskDTO) {
        Task tareaCreada = taskService.createTask(project_id, taskDTO);
        return ResponseEntity.created(URI.create("/v1/task" + tareaCreada.getId()))
                .body(tareaCreada);
    }

    // DELETE // Eliminar un Task

    public ResponseEntity<Void> deleteTask(@PathVariable("id") Long task_id) {
        taskService.deleteTask(task_id);
        return ResponseEntity.noContent()
                .build();
    }

    // GET // Obtener un Task

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable("id") Long task_id){
        Task task = taskService.getTaskById(task_id);
        return ResponseEntity.ok(task);
    }

    // PATCH // Actualizar Status
    @PatchMapping("/{id}")
    public ResponseEntity<Object> updateTaskStatus(@PathVariable("id") Long taskId, @RequestBody Map<String, String> requestBody) {
        String newStatusString = requestBody.get("status");

        TaskStatus newStatus;
        try {
            newStatus = TaskStatus.valueOf(newStatusString.toUpperCase());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of("mensaje", "el estado " + newStatusString + " no es válido"));
        }

        try {
            Task updatedTask = taskService.updateTaskStatus(taskId, newStatus);
            return ResponseEntity.ok(updatedTask);
        } catch (ApiRequestException e) {
            return ResponseEntity.badRequest().body(Map.of("mensaje", e.getMessage()));
        }
    }
}
