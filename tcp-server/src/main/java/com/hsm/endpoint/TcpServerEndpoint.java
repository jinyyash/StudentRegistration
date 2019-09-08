package com.hsm.endpoint;

import com.hsm.service.StudentService;
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

    @Autowired
    public TcpServerEndpoint(StudentService studentService) {
        this.studentService = studentService;
    }

    @ServiceActivator(inputChannel = "inboundChannel")
    public byte[] process(byte[] message) throws SQLException, IOException, ClassNotFoundException {
        return studentService.processMessage(message);
    }

}
