package com.example.backendwebshop.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "VARCHAR(255)")
    private String id;

    @Column
    @NotBlank(message = "Product name cannot be empty.")
    private String name;

    @Column
    @NotBlank(message = "Price cannot be empty.")
    private String price;

}
