package com.example.demo.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.example.demo.models.RoleDO;
import com.example.demo.models.UserDO;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails{

    private static final long serialVersionUID = 1L;

    /**
     * Kayıtlı kullanıcıların bilgilerini almak için Spring Security, UserDetails interface ini
     * miras alan bir sınıf oluşturmamıza ihtiyaç duyar.
     */

    private UserDO user;

    public MyUserDetails(UserDO user){
        this.user = user;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<RoleDO> roles = user.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for(RoleDO role: roles){
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return authorities;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.user.isEnabled();
    }
    
}
