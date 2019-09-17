package com.hsm.service.impl;

import com.google.gson.JsonObject;
import com.hsm.codette.DecodeJson;
import com.hsm.models.Student;
import com.hsm.models.User;
import com.hsm.repository.UserRepository;
import com.hsm.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;

@Service
public class UserServiceImpl implements UserService {

    private final Logger LOGGER= LogManager.getLogger(UserServiceImpl.class);
    @Autowired
    private DecodeJson decodeJson;

    @Autowired
    UserRepository userRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public byte[] processUser(byte[] message) throws IOException, SQLException, ClassNotFoundException {
        String messageContent = new String(message);
        boolean sucess= false;
        LOGGER.info("Receive message: {}", messageContent);
        User user= findByUsername(messageContent);

        String msg="";
        if(user!=null){
            msg=decodeJson.decodeUserToJson(user);
        }else{
            msg="";
        }
        return msg.getBytes();
    }
}
