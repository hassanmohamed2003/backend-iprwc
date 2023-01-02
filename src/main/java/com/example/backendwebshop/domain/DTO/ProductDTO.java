package com.example.backendwebshop.domain.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProductDTO {

    private String id;
    @NotBlank(message="Name cannot be empty.")
    private String name;
    @NotBlank(message="Price cannot be empty.")
    private String price;
}
