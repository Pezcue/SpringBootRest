package com.example.rest.DTO;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class TaskDTO {

    private String name;
    private String description;
    private String type;
    private LocalDate startDate;
    private LocalDate dueDate;

    public TaskDTO(String name, String description, String type, LocalDate startDate, LocalDate dueDate) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.startDate = startDate;
        this.dueDate = dueDate;
    }

    public TaskDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
