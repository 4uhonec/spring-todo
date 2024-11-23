package com.vilenski.todo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    private UUID id;

    private String description;

    private Boolean completed;

    @ManyToOne(fetch = FetchType.EAGER)
    private TaskList taskList;

    public void setTaskList(TaskList taskList) {
        this.taskList = taskList;
        taskList.getTasks().add(this);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", completed=" + completed +
                ", taskList=" + taskList.getTitle() +
                '}';
    }
}
