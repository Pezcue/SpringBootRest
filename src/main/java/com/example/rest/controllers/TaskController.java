package com.example.rest.controllers;

import com.example.rest.DTO.TaskDTO;
import com.example.rest.Exceptions.ApiRequestException;
import com.example.rest.Services.TaskServiceImpl;
import com.example.rest.entities.Task;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Map;

@RestController
@RequestMapping("/v1/task/")
public class TaskController {

    //Injeccion del servicio para Task

    private TaskServiceImpl taskService;

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
        String newStatus = requestBody.get("status");
        try {
            Task updatedTask = taskService.updateTaskStatus(taskId, newStatus);
            return ResponseEntity.ok(updatedTask);
        } catch (ApiRequestException e) {
            return ResponseEntity.badRequest().body(Map.of("mensaje", e.getMessage()));
        }
    }

}
