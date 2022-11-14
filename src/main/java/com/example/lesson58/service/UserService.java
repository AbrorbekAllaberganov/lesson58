package com.example.lesson58.service;


import com.example.lesson58.entity.User;
import com.example.lesson58.payload.UserPayload;

public interface UserService {
    User saveUser(UserPayload userPayload);
}
