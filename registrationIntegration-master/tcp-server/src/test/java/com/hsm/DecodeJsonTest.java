package com.hsm;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.hsm.codette.DecodeJson;
import com.hsm.models.Student;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

@SpringBootTest
public class DecodeJsonTest
{
    @Autowired
    DecodeJson decodeJson;

    @TestConfiguration
    static class EncodeJsonTestContextConfiguration {

        @Bean
        public DecodeJson decodeJson() {

            return new DecodeJson();
        }
        @Bean
        public ObjectMapper objectMapper(){
            return new ObjectMapper();
        }
    }

    @Test
    public void jsonStringConvertToStudentObj() throws IOException {
        String name="jinadee";
        String nic="957201423v";
        String address="matara";
        String tel="0715883767";

        JsonObject studentJson = new JsonObject();
        studentJson.addProperty("nic",nic);
        studentJson.addProperty("name",name);
        studentJson.addProperty("address", address);
        studentJson.addProperty("tel", tel);

        Student student=new Student(nic,name,address,tel);
        String jsonString=studentJson.toString();
        //Assert.assertEquals(student.getNic(),decodeJson.decodeJsonToStudent(jsonString).getNic());
        ObjectMapper mapper=new ObjectMapper();
        Student student1=mapper.readValue(jsonString, Student.class);
        System.out.println(student==student1);
    }
}
