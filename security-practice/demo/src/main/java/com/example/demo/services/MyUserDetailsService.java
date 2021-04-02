package com.example.demo.services;

import java.util.Optional;

import com.example.demo.models.MyUserDetails;
import com.example.demo.models.UserDO;
import com.example.demo.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    /**
     * loadUserByUsername metodu, Spring Security tarafından, kullanıcılar yetkilendirdiği zaman tetiklenecek.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserDO> user = userRepository.findByUsername(username);
        if(user.isPresent()) return new MyUserDetails(user.get());
        else throw new UsernameNotFoundException("Could not find user by username");
    }
    
}