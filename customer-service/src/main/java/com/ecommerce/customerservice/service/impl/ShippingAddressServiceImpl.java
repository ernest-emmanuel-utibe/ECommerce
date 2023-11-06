package com.ecommerce.customerservice.service.impl;

import com.ecommerce.commons.exceptions.NotFoundException;
import com.ecommerce.commons.utils.UpdatingUtil;
import com.ecommerce.customerservice.entity.Customer;
import com.ecommerce.customerservice.entity.ShippingAddress;
import com.ecommerce.customerservice.repository.ShippingAddressServiceRepository;
import com.ecommerce.customerservice.service.ShippingAddressService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShippingAddressServiceImpl implements ShippingAddressService {
    private final ShippingAddressServiceRepository shippingAddressServiceRepository;
    private final CustomerServiceImpl customerService;

    @Override
    public ShippingAddress createShippingAddress(Long customerId, ShippingAddress address) {
        Customer customer = customerService.getById(customerId);
        address.setCustomer(customer);
        return shippingAddressServiceRepository.save(address);
    }

    @Override
    public ShippingAddress getShippingAddressById(Long id) {
        return shippingAddressServiceRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Shipping address not found"));
    }

    @Override
    public List<ShippingAddress> getAllShippingAddressesByCustomerId(Long customerId) {
        return shippingAddressServiceRepository.findAllByCustomer_Id(customerId);
    }

    @Override
    public ShippingAddress updateShippingAddress(Long id, ShippingAddress addressDetails) {
        ShippingAddress address = getShippingAddressById(id);
        BeanUtils.copyProperties(addressDetails, address, UpdatingUtil.getNullPropertyNames(addressDetails));
        return shippingAddressServiceRepository.save(address);
    }

    @Override
    public void deleteShippingAddress(Long id) {
        shippingAddressServiceRepository.deleteById(id);
    }
}
