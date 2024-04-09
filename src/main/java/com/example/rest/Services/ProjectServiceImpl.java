package com.example.rest.Services;

import com.example.rest.entities.Project;
import com.example.rest.entities.projectStatus;
import com.example.rest.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project createProject(Project project) {

        // Chequear que el projecto no sea nulo y tenga un nombre
        if (project == null || project.getName() == null || project.getName().isEmpty()) {
            throw new IllegalArgumentException("Invalid project details");
        }

        // Aregarle los atributos por defecto
        project.setStatus(projectStatus.ACTIVE);
        project.setCreateDate(LocalDateTime.now());

        // Guardar (?) Preguntar
        return projectRepository.save(project);
    }


    @Override
    public Project editProject(Long id, Project project) {

        Optional <Project> optionalProject = projectRepository.findById(id);

        if (optionalProject.isPresent()) {

            projectRepository.save(project);

            return project;
        } else {
            throw new RuntimeException("El proyecto no existe"); // Cambiar por exp personalizada
        }
    }

    @Override
    public void deleteProject(Long id) {
        Optional <Project> projectOptional = projectRepository.findById(id);
        if(projectOptional.isPresent()){
            projectRepository.deleteById(id);
        } else {
            throw new RuntimeException("Proyecto con el id: " + id + " no existe.");
        }
    }

    @Override
    public Project getProjectById(Long id) {
        Optional <Project> projectOptional = projectRepository.findById(id);
        if(projectOptional.isPresent()) {
            return projectOptional.get();
        } else {
            throw new RuntimeException("Proyecto con el id: " + id + " no existe.");
        }
    }

}

