package com.project.simple_project.services;

import com.project.simple_project.model.dtos.ProductReceivedDTO;
import com.project.simple_project.model.entities.Product;
import com.project.simple_project.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService implements IProductService {
    private final ProductRepository productRepository;

    @Override
    public Product createProduct(ProductReceivedDTO productReceivedDTO) {
        Product product = new Product();
        product.setName(productReceivedDTO.getName());
        product.setPrice(productReceivedDTO.getPrice());
        product.setQuantity(productReceivedDTO.getQuantity());
        product.setTotal(productReceivedDTO.getPrice() * productReceivedDTO.getQuantity());
        return productRepository.save(product);
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
