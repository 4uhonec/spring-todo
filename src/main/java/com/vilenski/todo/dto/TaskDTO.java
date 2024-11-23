package com.vilenski.todo.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Validated
public class TaskDTO {

    private UUID id;

    @NotNull(message = "Description can not be null")
    private String description;

    @NotNull(message = "Completion status can not be null")
    private Boolean completed;

    @NotNull(message = "Task's task list can not be null")
    private UUID taskListId;

    @Override
    public String toString() {
        return "TaskDTO{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", completed=" + completed +
                ", taskListId=" + taskListId +
                '}';
    }
}
