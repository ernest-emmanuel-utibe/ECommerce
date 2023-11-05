package com.ecommerce.authservice.service.impl;

import com.ecommerce.authservice.feign.CustomerClient;
import com.ecommerce.authservice.model.UserDetailsImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService{
    private final CustomerClient customerClient;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        return new UserDetailsImpl(customerClient.getByUsername(username).getBody());
    }
}
