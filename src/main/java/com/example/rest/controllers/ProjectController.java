package com.example.rest.controllers;

import com.example.rest.DTO.ProjectDTO;
import com.example.rest.Services.ProjectServiceImpl;
import com.example.rest.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;


@RestController
@RequestMapping("/v1/projects")
public class ProjectController {

    // Injeccion del servicio
    private ProjectServiceImpl projectService ;

    @Autowired
    public ProjectController(ProjectServiceImpl projectService) {
        this.projectService = projectService;
    }


    //POST -> /v1/projects crear un Project
    @PostMapping("/")
    public ResponseEntity<Project> createProject(@RequestBody ProjectDTO projectDTO) {
        Project projectoCreado = projectService.createProject(projectDTO);
        return ResponseEntity.created(URI.create("/v1/projects" + projectoCreado.getId()))
                .body(projectoCreado);
    }

    // PUT -> /v1/projects/{id} editar un Project
    @PutMapping("/{id}")
    public ResponseEntity<Project> editProject(@PathVariable("id") Long id,
                                                  @RequestBody Project project) {
        Project proyectoEditado = projectService.editProject(id, project);
        return ResponseEntity.created(URI.create("/v1/projects" + proyectoEditado.getId()))
                .body(proyectoEditado);
    }

    // DELETE -> /v1/projects/{id} eliminar un Project
    public ResponseEntity<Void> eliminarProjecto(@PathVariable("id") Long id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent()
                .build();
    }

    // GET -> /v1/projects/{id} obtener un Project por id
    @GetMapping("/{id}")
    public ResponseEntity<Project> getProject(@PathVariable("id") Long id) {
        Project project = projectService.getProjectById(id);
        return ResponseEntity.ok(project);
    }

}
