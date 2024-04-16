package com.example.rest.Services;

import com.example.rest.DTO.TaskDTO;
import com.example.rest.Exceptions.ApiRequestException;
import com.example.rest.entities.Project;
import com.example.rest.entities.Task;
import com.example.rest.entities.TaskStatus;
import com.example.rest.repositories.ProjectRepository;
import com.example.rest.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;

    public TaskServiceImpl(TaskRepository taskRepository, ProjectRepository projectRepository) {
        this.taskRepository = taskRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    public Task createTask(long project_id, TaskDTO taskDTO) {

        Project proyectoBaseDeDatos = projectRepository.findProjectById(project_id);
        if (proyectoBaseDeDatos != null) {
            throw new ApiRequestException("Ya existe en la base de datos");
        }

        Task newTask = new Task();
        newTask.setName(taskDTO.getName());
        newTask.setDescription(taskDTO.getDescription());
        newTask.setTaskStatus(TaskStatus.TODO.toString());
        newTask.setType(taskDTO.getType());
        newTask.setStartDate(taskDTO.getStartDate());
        newTask.setDueDate(taskDTO.getDueDate());
        newTask.setCreateDate(LocalDate.now());
        newTask.setLastUpdatedDate(LocalDateTime.now());

        Task savedTask = taskRepository.save(newTask);
        return newTask;
    }

    @Override
    public void deleteTask(Long task_id) {
        Optional <Task> taskOptional = taskRepository.findById(task_id);
        if(taskOptional.isPresent()){
            taskRepository.deleteById(task_id);
        } else {
            throw new ApiRequestException("La tarea no existe");
        }
    }

    @Override
    public Task getTaskById(Long task_id) {
        Optional <Task> taskOptional = taskRepository.findById(task_id);
        if(taskOptional.isPresent()){
            return taskOptional.get();
        } else {
            throw new ApiRequestException("La tarea no existe");
        }
    }

    @Override
    public Task updateTaskStatus(Long taskId, String newStatus) throws ApiRequestException {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new ApiRequestException("Task not found with id: " + taskId));

        TaskStatus currentStatus = TaskStatus.valueOf(task.getTaskStatus());
        TaskStatus updatedStatus;

        try {
            updatedStatus = TaskStatus.valueOf(newStatus.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new ApiRequestException("el estado " + newStatus + " no es válido");
        }

        if (!isValidStatusTransition(currentStatus, updatedStatus)) {
            throw new ApiRequestException("no es posible asignar al estado " + updatedStatus +
                    " una tarea con estado " + currentStatus);
        }

        task.setTaskStatus(String.valueOf(updatedStatus));
        return taskRepository.save(task);
    }

    private boolean isValidStatusTransition(TaskStatus currentStatus, TaskStatus newStatus) {
        // validar los estados (Preguntar)

        return (currentStatus == TaskStatus.TODO && newStatus == TaskStatus.IN_PROGRESS) ||
                (currentStatus == TaskStatus.IN_PROGRESS && (newStatus == TaskStatus.BLOCKED || newStatus == TaskStatus.DONE)) ||
                (currentStatus == TaskStatus.BLOCKED && (newStatus == TaskStatus.IN_PROGRESS || newStatus == TaskStatus.DONE));
    }


}
