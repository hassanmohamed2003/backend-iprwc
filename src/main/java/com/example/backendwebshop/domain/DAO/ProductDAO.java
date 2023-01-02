package com.example.backendwebshop.domain.DAO;

import com.example.backendwebshop.domain.entity.Product;
import com.example.backendwebshop.domain.exception.ResourceNotFoundException;
import com.example.backendwebshop.domain.repository.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDAO implements DAO<Product>{


    private final ProductRepository productRepository;

    public ProductDAO(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product getById(String id) throws ResourceNotFoundException {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", id));
    }

    @Override
    public Product saveToDatabase(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public Product update(String id, Product productRequest) throws ResourceNotFoundException {
        Product product = this.productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", id));

        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        return productRepository.save(product);
    }

    @Override
    public void delete(String id) throws ResourceNotFoundException {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", id));

        this.productRepository.deleteById(id);
    }

    @Override
    public List<Product> getAll() {
        return this.productRepository.findAll();
    }
}
