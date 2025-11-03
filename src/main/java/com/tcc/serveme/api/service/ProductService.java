package com.tcc.serveme.api.service;

import com.tcc.serveme.api.model.Product;
import com.tcc.serveme.api.model.ProductImage;
import com.tcc.serveme.api.repository.ProductRepository;
import com.tcc.serveme.api.repository.ProductImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductImageRepository productImageRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductImageRepository productImageRepository) {
        this.productRepository = productRepository;
        this.productImageRepository = productImageRepository;
    }

    @Transactional
    public Product createProduct(Product product) {
        long productId = productRepository.save(product);
        product.setId(productId);

        if (product.getImages() != null && !product.getImages().isEmpty()) {
            for (String imageUrl : product.getImages()) {
                ProductImage productImage = new ProductImage();
                productImage.setFkProduct(productId);
                productImage.setImage(imageUrl);
                productImageRepository.save(productImage);
            }
        }

        return product;
    }
}
