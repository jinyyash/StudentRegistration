package com.hsm.codette;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.hsm.models.Student;
import com.hsm.models.User;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class DecodeJson {

    public Student decodeJsonToStudent(String studentJsonString) throws IOException {
        ObjectMapper mapper=new ObjectMapper();
        return mapper.readValue(studentJsonString, Student.class);
    }
    public String decodeUserToJson(User user){
        JsonObject userJson=new JsonObject();
        userJson.addProperty("userName",user.getUserName());
        userJson.addProperty("password",user.getPassword());
        userJson.addProperty("role",user.getRole());
        return userJson.toString();
    }
}
