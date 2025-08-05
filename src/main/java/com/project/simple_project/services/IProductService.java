package com.project.simple_project.services;

import com.project.simple_project.model.dtos.ProductReceivedDTO;
import com.project.simple_project.model.entities.Product;

public interface IProductService {
    Product createProduct(ProductReceivedDTO productReceivedDTO);

    Product getProduct(Long id);
}
