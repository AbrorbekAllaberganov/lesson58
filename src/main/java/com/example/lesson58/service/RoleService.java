package com.example.lesson58.service;

import com.example.lesson58.entity.Role;

import java.util.List;

public interface RoleService {
//    Role findById(Long id);
    List<Role> getRoles(List<Long> rolesId);
}
