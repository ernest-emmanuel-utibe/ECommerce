package com.ecommerce.catalogservice.mapper;
import com.ecommerce.catalogservice.entity.Product;
import com.ecommerce.catalogservice.service.ProductService;
import com.ecommerce.commons.dto.catalog.product.ProductRequest;
import com.ecommerce.commons.dto.catalog.product.ProductResponse;
import com.ecommerce.commons.mapper.BasicMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@RequiredArgsConstructor
public class ProductMapper {

    private final BasicMapper basicMapper;
    private final ProductService productService;

    public Page<ProductResponse> getProducts(Pageable pageable) {
        return productService.getAll(pageable).map(product -> basicMapper.convertTo(product, ProductResponse.class));
    }

    public ProductResponse getProductById(Long productId) {
        return basicMapper.convertTo(productService.getById(productId), ProductResponse.class);
    }

    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = productService.create(basicMapper.convertTo(productRequest, Product.class), productRequest.getCategoryId());
        return basicMapper.convertTo(product, ProductResponse.class);
    }

    public ProductResponse uploadImages(MultipartFile[] images, Long productId) {
        return basicMapper.convertTo(productService.uploadImages(images, productId), ProductResponse.class);
    }

    public ProductResponse updateProduct(Long productId, ProductRequest productRequest) {
        Product product = productService.update(productId, basicMapper.convertTo(productRequest, Product.class), productRequest.getCategoryId());
        return basicMapper.convertTo(product, ProductResponse.class);
    }

    public void deleteProduct(Long id) {
        productService.deleteProduct(id);
    }

}
