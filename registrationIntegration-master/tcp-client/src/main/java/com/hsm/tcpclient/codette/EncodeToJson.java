package com.hsm.tcpclient.codette;

import com.google.gson.JsonObject;
import com.hsm.tcpclient.models.Student;
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
    public String encodeStudentToJsonString(Student student){
        JsonObject studentJ = new JsonObject();
        studentJ.addProperty("nic", student.getNic());
        studentJ.addProperty("name", student.getName());
        studentJ.addProperty("address", student.getAddress());
        studentJ.addProperty("tel", student.getTel());
        return studentJ.toString();
    }
}
