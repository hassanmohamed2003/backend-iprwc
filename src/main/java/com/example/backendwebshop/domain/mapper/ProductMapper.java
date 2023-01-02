package com.example.backendwebshop.domain.mapper;

import com.example.backendwebshop.domain.DAO.ProductDAO;
import com.example.backendwebshop.domain.DTO.ProductDTO;
import com.example.backendwebshop.domain.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper implements Mapper<Product, ProductDTO>{

    private final ProductDAO productDAO;

    public ProductMapper(ProductDAO productDAO){
        this.productDAO = productDAO;
    }
    @Override
    public Product fromDTOToEntity(ProductDTO productDTO) {

        if ( productDTO == null) {
            return null;
        }

        Product product = new Product();

        product.setId( productDTO.getId());
        product.setPrice( productDTO.getPrice());
        product.setName( productDTO.getName());

        return product;
    }

    @Override
    public ProductDTO fromEntityToDTO(Product product) {

        if ( product == null){
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        productDTO.setId(product.getId());
        productDTO.setPrice(product.getPrice());
        productDTO.setName(product.getName());

        return productDTO;
    }

    @Override
    public Product fromIdToEntity(String id) {

        if ( id == null ) {
            return null;
        }

        return productDAO.getById(id);
    }
}
