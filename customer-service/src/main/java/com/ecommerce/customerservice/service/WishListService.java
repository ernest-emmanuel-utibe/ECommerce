package com.ecommerce.customerservice.service;

import com.ecommerce.customerservice.dto.request.WishlistRequest;
import com.ecommerce.customerservice.entity.Wishlist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface WishListService {
    Wishlist create(WishlistRequest wishlist);
    Page<Wishlist> getAllByCustomerId(Long id, Pageable pageable);
    void delete(Long id);
}
