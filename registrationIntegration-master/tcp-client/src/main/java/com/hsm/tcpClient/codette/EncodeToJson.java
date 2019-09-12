package com.hsm.tcpClient.codette;

import com.google.gson.JsonObject;
import org.springframework.stereotype.Component;

@Component
public class EncodeToJson {
    public JsonObject encodeStringToJson(String nic, String name, String address, String tel){
        //creating student json object
        JsonObject student = new JsonObject();
        student.addProperty("nic", nic);
        student.addProperty("name", name);
        student.addProperty("address", address);
        student.addProperty("tel", tel);
        return student;
    }
}
