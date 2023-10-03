package com.example.pizzeria.service;

import com.example.pizzeria.persistence.entity.UserEntity;
import com.example.pizzeria.persistence.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserSecurityService implements UserDetailsService {


    private final UserRespository userRespository;

    @Autowired
    public UserSecurityService(UserRespository userRespository) {
        this.userRespository = userRespository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        UserEntity userEntity = this.userRespository.findById(username)
//                .orElseThrow(() -> new UsernameNotFoundException("user " + username + " not found"));
//
//        return User.builder()
//                .username(userEntity.getUsername())
//                .password(userEntity.getPassword())
//                .roles("ADMIN")
//                .accountLocked(userEntity.getLocked())
//                .disabled(userEntity.getDisabled())
//                .build();
        return User.builder().username("paul").password("abc123").build();
    }
}
