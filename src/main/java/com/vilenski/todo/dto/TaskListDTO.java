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
public class TaskListDTO {

    private UUID id;

    @NotNull(message = "Title can not be null")
    private String title;

    @NotNull(message = "Customer id cannot be null")
    private UUID customerId;

}
