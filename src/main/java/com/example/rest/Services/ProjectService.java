package com.example.rest.Services;

import com.example.rest.entities.Project;

public interface ProjectService {

    // para crear projectos
    Project createProject(Project project);

    // para editar projectos
    Project editProject(Long id, Project project);

    // para eliminar projectos
    void deleteProject(Long id);

    // para obtener projecto por id
    Project getProjectById(Long id);
}
