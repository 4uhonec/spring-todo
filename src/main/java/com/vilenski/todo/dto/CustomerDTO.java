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
public class CustomerDTO {//todo: implements Serializable?

    private UUID id;

    @NotNull(message = "Name can not be null")
    private String name;

    @NotNull(message = "Email can not be null")
    private String email;

}
