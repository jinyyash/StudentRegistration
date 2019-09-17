package com.hsm.repository;

import com.hsm.models.User;

public interface UserRepository {
    User findByUsername(String username);

}
