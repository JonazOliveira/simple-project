package com.project.simple_project.model.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductReceivedDTO {
    private String name;
    private Double price;
    private Integer quantity;
}
