package com.example.demo.security;

import com.example.demo.model.AppUser;
import com.example.demo.repository.AppUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class AppUserPrincipalDetailsService implements UserDetailsService {
    private AppUserRepository appUserRepository;

    public AppUserPrincipalDetailsService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        AppUser appUser = this.appUserRepository.findByUsername(s);

        AppUserPrincipal appUserPrincipal = new AppUserPrincipal(appUser);

        return appUserPrincipal;


    }
}
