package com.hsm.service;

import com.hsm.tcpclient.codette.EncodeToJson;
import com.hsm.tcpclient.models.User;
import com.hsm.tcpclient.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveUserDetailsServiceAutoConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.io.IOException;

public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    MessageService messageService;
    @Autowired
    EncodeToJson encodeToJson;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=null;
        try {
             user=findUserByUserName(username);
        } catch (IOException e) {
            e.printStackTrace();
        }
            org.springframework.security.core.userdetails.User.UserBuilder builder = null;
            if (user != null) {
                builder = org.springframework.security.core.userdetails.User.withUsername(username);
                builder.password("{noop}"+user.getPassword());
                builder.roles(user.getRole());
            } else {
                throw new UsernameNotFoundException("User not found.");
            }
            return builder.build();
    }

    private User findUserByUserName(String userName) throws IOException {
        System.out.println("-------------------------user details methos involk-------");
        User user=encodeToJson.encodeUserStringToJson(messageService.sendUserDetails(userName));
        return user;
    }
}
