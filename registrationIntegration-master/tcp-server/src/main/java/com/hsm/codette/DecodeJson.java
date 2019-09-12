package com.hsm.codette;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hsm.models.Student;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class DecodeJson {

    public Student decodeJsonToStudent(String studentJsonString) throws IOException {
        ObjectMapper mapper=new ObjectMapper();
        return mapper.readValue(studentJsonString, Student.class);
    }
}
