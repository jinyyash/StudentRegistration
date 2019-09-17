package com.hsm.service;

import com.hsm.models.User;

import java.io.IOException;
import java.sql.SQLException;

public interface UserService {
    User findByUsername(String username);
    byte[] processUser(byte[] message) throws IOException, SQLException, ClassNotFoundException;

}
