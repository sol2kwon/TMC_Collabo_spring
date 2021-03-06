package com.toomuchcoder.api.auth.service;

import com.toomuchcoder.api.auth.domain.Auth;
import com.toomuchcoder.api.user.domain.User;
import com.toomuchcoder.api.user.repositorie.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * packageName: com.toomuchcoder.api.auth.services
 * fileName        : AuthServiceImpl.java
 * author          : solyikwon
 * date            : 2022-06-05
 * desc            :
 * =============================================
 * DATE              AUTHOR        NOTE
 * =============================================
 * 2022-06-05         solyikwon      최초 생성
 **/
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements UserDetailsService {
    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = Optional.ofNullable(repository.findByUsername(username))
                .orElseThrow(()->new UsernameNotFoundException(username+"에 해당하는 객체가 존재하지 않습니다."));
        return Auth.build(user.get());
    }
}

