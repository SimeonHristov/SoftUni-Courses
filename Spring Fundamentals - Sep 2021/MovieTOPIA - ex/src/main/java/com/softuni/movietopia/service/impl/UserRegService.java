package com.softuni.movietopia.service.impl;

import com.softuni.movietopia.model.entities.UserEntity;
import com.softuni.movietopia.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserRegService implements UserDetailsService {

  private final UserRepository userRepository;

  public UserRegService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
  UserEntity userEntity = userRepository.
        findByUsername(username).
        orElseThrow(() -> new UsernameNotFoundException("User with name " + username + " was not found!"));

    return mapToUserDetails(userEntity);
  }

  private UserDetails mapToUserDetails(UserEntity userEntity) {
    List<GrantedAuthority> authorities =
        userEntity.
            getRoles().
            stream().
            map(r -> new SimpleGrantedAuthority("ROLE_" + r.getRole().name())).
            collect(Collectors.toList());

    return new User(
        userEntity.getUsername(),
        userEntity.getPassword(),
        authorities
    );
  }
}
