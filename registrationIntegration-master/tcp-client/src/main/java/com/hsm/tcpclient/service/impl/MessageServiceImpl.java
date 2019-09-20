package com.hsm.tcpclient.service.impl;

import com.hsm.tcpclient.service.MessageService;
import com.hsm.tcpclient.codette.EncodeToJson;
import com.hsm.tcpclient.gateway.TcpClientGateway;
import com.hsm.tcpclient.models.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MessageServiceImpl implements MessageService {

    private final static Logger logger= LogManager.getLogger(MessageService.class);
    public static  String RESPONSE;
    private TcpClientGateway tcpClientGateway;
    @Autowired
    private EncodeToJson encodeToJson;
    @Autowired
    public MessageServiceImpl(TcpClientGateway tcpClientGateway) {

        this.tcpClientGateway = tcpClientGateway;
    }


    public void sendMessage(Student student) {
        String message =encodeToJson.encodeStudentToJsonString(student) ;
        logger.info("Send message: {}", message);
        byte[] responseBytes = tcpClientGateway.send(message.getBytes());
         RESPONSE = new String(responseBytes);
        logger.info("Receive response: {}", RESPONSE);
    }

    @Override
    public String sendUserDetails(String userName) {
        byte[] responseBytes = tcpClientGateway.send(userName.getBytes());
        String response = new String(responseBytes);
        return response;
    }


}
