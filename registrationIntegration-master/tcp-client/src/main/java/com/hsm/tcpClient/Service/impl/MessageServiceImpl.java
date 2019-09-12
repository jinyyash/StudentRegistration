package com.hsm.tcpClient.Service.impl;

import com.google.gson.JsonObject;
import com.hsm.tcpClient.Service.MessageService;
import com.hsm.tcpClient.gateway.TcpClientGateway;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MessageServiceImpl implements MessageService {

    private final static Logger logger= LogManager.getLogger(MessageService.class);

    private TcpClientGateway tcpClientGateway;

    @Autowired
    public MessageServiceImpl(TcpClientGateway tcpClientGateway) {

        this.tcpClientGateway = tcpClientGateway;
    }


    public void sendMessage(JsonObject jsonObject) {
        String message = jsonObject.toString();
        logger.info("Send message: {}", message);
        byte[] responseBytes = tcpClientGateway.send(message.getBytes());
        String response = new String(responseBytes);
        logger.info("Receive response: {}", response);
    }


}
