package com.example.rest.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "proyecto")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "descripcion")
    private String description;

    @Column(name = "status")
    private String status;

    @Column(name = "fecha_creacion")
    private LocalDateTime createDate;

    @Column(name = "fecha_actualizacion")
    private LocalDateTime lastUpdatedDate;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Task> userProyectList = new ArrayList<>();


    public Project(Long id, String name, String description, LocalDateTime createDate, LocalDateTime lastUpdatedDate, List<Task> userProyectList) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createDate = createDate;
        this.lastUpdatedDate = lastUpdatedDate;
        this.userProyectList = userProyectList;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public LocalDateTime getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public List<Task> getUserProyectList() {
        return userProyectList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public void setUserProyectList(List<Task> userProyectList) {
        this.userProyectList = userProyectList;
    }
}
