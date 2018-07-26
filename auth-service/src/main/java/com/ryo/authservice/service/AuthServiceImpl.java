package com.ryo.authservice.service;

import com.ryo.authservice.model.AuthKey;
import com.ryo.authservice.model.User;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public User auth(AuthKey authKey) {

        return new User(1L);
    }
}
