package com.ecommerce.catalogservice.service;

import com.ecommerce.catalogservice.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface ProductService {
    Product create(Product product, Long categoryId);
    Product update(Long productId, Product product, Long categoryId);
    Product update(Product product);
    Product uploadImages(MultipartFile[] images, Long productId);
    void updateOrderCount(Long productId, boolean increase);
    Page<Product> getAll(Pageable pageable);
    Product getById(Long productId);
    void deleteProduct(Long productId);
}
