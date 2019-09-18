package com.hsm.endpoint;

import com.hsm.service.StudentService;
import com.hsm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.sql.SQLException;

@MessageEndpoint
@Controller
public class TcpServerEndpoint {

    private StudentService studentService;

    private UserService userService;

    @Autowired
    public TcpServerEndpoint(StudentService studentService,UserService userService) {
        this.studentService = studentService;
        this.userService=userService;
    }

    @ServiceActivator(inputChannel = "inboundChannel")
    public byte[] process(byte[] message) throws SQLException, IOException, ClassNotFoundException {
        return studentService.processMessage(message);
    }
    @ServiceActivator(inputChannel = "inboundChannel")
    public byte[] processUser(byte [] message) throws SQLException, IOException, ClassNotFoundException {
        return userService.processUser(message);
    }

}
