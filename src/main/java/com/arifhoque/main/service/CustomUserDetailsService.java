package com.arifhoque.main.service;

import com.arifhoque.main.model.Authority;
import com.arifhoque.main.model.User;
import com.arifhoque.main.repository.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepo.findUserByEmail(email);

        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Authority authority : user.getAuthorities())
            authorities.add(new SimpleGrantedAuthority(authority.getAuthority()));

        return new org.springframework.security.core.userdetails.User(email, user.getPassword(),authorities);
    }
}
