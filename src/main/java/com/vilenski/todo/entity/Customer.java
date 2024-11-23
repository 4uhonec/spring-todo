package com.vilenski.todo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;


@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    private UUID id;

    @NotNull
    @NotBlank
    private String username;

    @NotNull
    @NotBlank
    private String password;

    @NotNull
    @NotBlank
    private String email;

    @Builder.Default
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<TaskList> taskLists = new HashSet<>();

    @Override
    public String toString() {
        List<String> list = taskLists.stream().map(TaskList::getTitle).toList();
        return "Customer{" +
                "id=" + id +
                ", name='" + username + '\'' +
                ", email='" + email + '\'' +
                ", taskLists=" + list +
                '}';
    }
}