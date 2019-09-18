package com.hsm.tcpclient.codette;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.hsm.tcpclient.models.Student;
import com.hsm.tcpclient.models.User;
import org.springframework.stereotype.Component;

import java.io.IOException;

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
    public String encodeStudentToJsonString(Student student){
        JsonObject studentJ = new JsonObject();
        studentJ.addProperty("nic", student.getNic());
        studentJ.addProperty("name", student.getName());
        studentJ.addProperty("address", student.getAddress());
        studentJ.addProperty("tel", student.getTel());
        return studentJ.toString();
    }
    public User encodeUserStringToJson(String jsonString) throws IOException {
        if(jsonString.equals("")){
            return null;
        }else{
            ObjectMapper mapper=new ObjectMapper();
            return mapper.readValue(jsonString, User.class);
        }

    }
}
