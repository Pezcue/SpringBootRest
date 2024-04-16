package com.example.rest.Services;

import com.example.rest.DTO.ProjectDTO;
import com.example.rest.Exceptions.ApiRequestException;
import com.example.rest.entities.Project;
import com.example.rest.entities.Task;
import com.example.rest.entities.projectStatus;
import com.example.rest.repositories.ProjectRepository;
import com.example.rest.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final TaskRepository taskRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository, TaskRepository taskRepository) {
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public Project createProject(ProjectDTO projectDTO) {

        Project newProject = new Project();
        newProject.setName(projectDTO.getName());
        newProject.setDescription(projectDTO.getDescription());
        newProject.setStatus(projectStatus.ACTIVE.toString());
        newProject.setCreateDate(LocalDateTime.now());
        newProject.setLastUpdatedDate(LocalDateTime.now());

        // Guardar
        Project savedProject = projectRepository.save(newProject);
        return savedProject;
    }

    @Override
    public Project editProject(Long id, Project project) {

        Optional <Project> optionalProject = projectRepository.findById(id);

        if (optionalProject.isPresent()) {

            projectRepository.save(project);

            return project;
        } else {
            throw new ApiRequestException("El proyecto no existe con expresion personalizada");
        }
    }

    @Override
    public void deleteProject(Long id) {
        Optional <Project> projectOptional = projectRepository.findById(id);
        if(projectOptional.isPresent()){
            projectRepository.deleteById(id);
        } else {
            throw new ApiRequestException("Proyecto con el id: " + id + " no existe.");
        }
    }

    @Override
    public Project getProjectById(Long id) {
        Optional <Project> projectOptional = projectRepository.findById(id);
        if(projectOptional.isPresent()) {
            return projectOptional.get();
        } else {
            throw new ApiRequestException("Proyecto con el id: " + id + " no existe.");
        }
    }


    public Map<String, Object> getAllProjectTasks(Long projectId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ApiRequestException("Project not found with id: " + projectId));

        List<Task> tasks = taskRepository.findByProjectId(projectId);

        Map<String, List<Task>> board = tasks.stream()
                .collect(Collectors.groupingBy(task -> task.getTaskStatus().toString()));

        return Map.of(
                "project", Map.of(
                        "id", project.getId(),
                        "name", project.getName()
                ),
                "board", board.entrySet().stream()
                        .map(entry -> Map.of("status", entry.getKey(), "tasks", entry.getValue()))
                        .collect(Collectors.toList())
        );
    }

}

