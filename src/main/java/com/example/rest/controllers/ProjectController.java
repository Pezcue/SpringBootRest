package com.example.rest.controllers;

import com.example.rest.Services.ProjectoService;
import com.example.rest.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/v1/projects")
public class ProjectController {

    // Injeccion del servicio
    private final ProjectoService projectoService;

    @Autowired
    public ProjectController(ProjectoService projectoService) {
        this.projectoService = projectoService;
    }


    //POST -> /v1/projects crear un Project
    @PostMapping
    public ResponseEntity<Project> crearProjecto(@RequestBody Project project) {
        Project projectoCreado = projectoService.crearProjecto(project);
        return ResponseEntity.created(URI.create("/v1/projects" + projectoCreado.getId()))
                .body(projectoCreado);
    }

    // PUT -> /v1/projects/{id} editar un Project
    @PutMapping("/{id}")
    public ResponseEntity<Project> editarProjecto(@PathVariable("id") Long id,
                                                  @RequestBody Project project) {

    }

    // DELETE -> /v1/projects/{id} eliminar un Project
    public ResponseEntity<Void> eliminarProjecto(@PathVariable("id") Long id) {

    }

    // GET -> /v1/projects/{id} obtener un Project por i
    @GetMapping("/{id}")
    public ResponseEntity<Project> obtenerProjecto(@PathVariable("id") Long id) {

    }



}
