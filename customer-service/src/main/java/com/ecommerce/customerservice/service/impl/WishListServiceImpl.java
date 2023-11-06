package com.ecommerce.customerservice.service.impl;

import com.ecommerce.customerservice.dto.request.WishlistRequest;
import com.ecommerce.customerservice.entity.Customer;
import com.ecommerce.customerservice.entity.Wishlist;
import com.ecommerce.customerservice.feign.ProductClient;
import com.ecommerce.customerservice.repository.WishlistRepository;
import com.ecommerce.customerservice.service.CustomerService;
import com.ecommerce.customerservice.service.WishListService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WishListServiceImpl implements WishListService {
    private final WishlistRepository wishlistRepository;
    private final CustomerService customerService;
    private final ProductClient productClient;

    @Override
    public Wishlist create(WishlistRequest wishlistRequest) {
        Wishlist wishlist = new Wishlist();
        Customer customer = customerService.getById(wishlistRequest.getCustomerId());
        Long productId = productClient.getProductById(wishlistRequest.getProductId()).getBody().getId();;
        wishlist.setCustomer(customer);
        wishlist.setProductId(productId);
        return wishlistRepository.save(wishlist);
    }

    @Override
    public Page<Wishlist> getAllByCustomerId(Long id, Pageable pageable) {
        return wishlistRepository.findAllByCustomer_Id(id, pageable);
    }

    @Override
    public void delete(Long id) {
        wishlistRepository.deleteById(id);
    }

}
