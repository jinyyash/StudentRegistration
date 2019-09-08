package com.hsm.tcpClient.Service;

import com.google.gson.JsonObject;

public interface MessageService {

    void sendMessage(JsonObject jsonObject);

}
