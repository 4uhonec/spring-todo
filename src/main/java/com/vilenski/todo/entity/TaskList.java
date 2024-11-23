package com.vilenski.todo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskList {

    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Builder.Default
    @OneToMany(mappedBy = "taskList", cascade = CascadeType.ALL)
    private Set<Task> tasks = new HashSet<>();

    @ManyToOne
    private Customer customer;

    public void setCustomer(Customer customer) {
        this.customer = customer;
        customer.getTaskLists().add(this);
    }

    @Override
    public String toString() {
        return "TaskList{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", tasks=" + tasks +
                ", customer mail=" + customer.getEmail() +
                '}';
    }
}
