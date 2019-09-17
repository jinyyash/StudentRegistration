package com.hsm;

import com.google.gson.JsonObject;
import com.hsm.tcpclient.codette.EncodeToJson;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class EncodeToJsonTest {
    @Autowired
    EncodeToJson encodeToJson;

    @TestConfiguration
    static class EncodeJsonTestContextConfiguration {

        @Bean
        public EncodeToJson encodeToJson() {

            return new EncodeToJson();
        }
    }

    @Test
    public void whenEncodeStringToJsonObject(){
        String nic="957201423v";
        String name="jinade";
        String address="matara";
        String tel="0715883767";

        JsonObject student = new JsonObject();
        student.addProperty("nic", nic);
        student.addProperty("name", name);
        student.addProperty("address", address);
        student.addProperty("tel", tel);

        Assert.assertEquals(encodeToJson.encodeStringToJson(nic,name,address,tel),student);

    }
}
