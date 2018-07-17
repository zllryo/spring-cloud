package com.ryo.authservice.service;

import com.ryo.authservice.model.AuthKey;
import com.ryo.authservice.model.User;

public interface AuthService {
    User auth(AuthKey authKey);
}
