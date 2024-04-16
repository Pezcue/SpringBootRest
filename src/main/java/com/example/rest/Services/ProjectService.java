package com.example.rest.Services;

import com.example.rest.DTO.ProjectDTO;
import com.example.rest.entities.Project;
import com.example.rest.entities.Task;

import java.util.List;
import java.util.Map;

public interface ProjectService {

    // para crear projectos
    Project createProject(ProjectDTO projectDTO);

    // para editar projectos
    Project editProject(Long id, Project project);

    // para eliminar projectos
    void deleteProject(Long id);

    // para obtener projecto por id
    Project getProjectById(Long id);

    // para obtener todas las tareas de un proyecto por su estado
    Map<String, Object> getAllProjectTasks(Long projectId);

}
