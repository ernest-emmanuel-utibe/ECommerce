package com.ecommerce.catalogservice.mapper;

import com.ecommerce.catalogservice.dto.request.CategoryRequest;
import com.ecommerce.catalogservice.entity.Category;
import com.ecommerce.catalogservice.service.CategoryService;
import com.ecommerce.commons.dto.catalog.category.CategoryResponse;
import com.ecommerce.commons.dto.catalog.product.ProductResponse;
import com.ecommerce.commons.mapper.BasicMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CategoryMapper {

    private final BasicMapper basicMapper;
    private final CategoryService categoryService;

    public List<CategoryResponse> getCategories() {
        return basicMapper.convertListTo(categoryService.getAll(), CategoryResponse.class);
    }

    public CategoryResponse createCategory(CategoryRequest categoryRequest) {
        Category category = basicMapper.convertTo(categoryRequest, Category.class);
        categoryService.setParentCategory(categoryRequest.getParentCategoryId(), category);
        return basicMapper.convertTo(categoryService.create(category), CategoryResponse.class);
    }

    public CategoryResponse getById(Long id) {
        return basicMapper.convertTo(categoryService.getCategoryById(id), CategoryResponse.class);
    }

    public Page<ProductResponse> getProductsByCategoryId(Long id, Pageable pageable) {
        return categoryService.getProductsByCategory(id, pageable).map(product -> basicMapper.convertTo(product, ProductResponse.class));
    }

    public CategoryResponse updateCategory(Long id, CategoryRequest categoryRequest) {

        Category category = null;
        if(categoryRequest.getParentCategoryId() != null) {
            category = categoryService.updateCategory(id, categoryRequest.getParentCategoryId(), basicMapper.convertTo(categoryRequest, Category.class));
        } else {
            category = categoryService.updateCategory(id, basicMapper.convertTo(categoryRequest, Category.class));
        }
        return basicMapper.convertTo(category, CategoryResponse.class);
    }

    public void deleteBanner(Long id) {
        categoryService.deleteBanner(id);
    }

    public void deleteCategory(Long id) {
        categoryService.deleteCategory(id);
    }

    public CategoryResponse uploadBanners(Long id, MultipartFile[] banners) {
        return basicMapper.convertTo(categoryService.uploadBanners(id, banners), CategoryResponse.class);
    }
}
