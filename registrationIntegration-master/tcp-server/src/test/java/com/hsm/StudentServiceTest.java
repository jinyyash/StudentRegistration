package com.hsm;

import com.google.gson.JsonObject;
import com.hsm.codette.DecodeJson;
import com.hsm.models.Student;
import com.hsm.repository.StudentRepository;
import com.hsm.service.StudentService;
import com.hsm.service.impl.StudentServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class StudentServiceTest {
    @TestConfiguration
    static class StudentServiceImplTestContextConfiguration {

        @Bean
        public StudentService studentService() {

            return new StudentServiceImpl();
        }
        @Bean
        public DecodeJson decodeJson(){
            return new DecodeJson();
        }
    }
    @Autowired
    private StudentService studentService;
    //used to bypass the call to the actual Repository:
    @MockBean
    private StudentRepository studentRepository;

    @Test
    public void testSave() throws SQLException, IOException, ClassNotFoundException {
        boolean sucess;
        Student student=new Student();
        student.setNic("9007201423V");
        student.setName("jinadi");
        student.setAddress("matara");
        student.setTel("0715886767");
        Mockito.when(studentRepository.save(student)).thenReturn(true);
        sucess=studentService.save(student);
        System.out.println(sucess);
        assertThat(sucess).isEqualTo(true);
    }

    @Test
    public void testProcessMessage() throws SQLException, IOException, ClassNotFoundException {
        JsonObject studentJson = new JsonObject();
        studentJson.addProperty("nic", "957201423v");
        studentJson.addProperty("name","jinadee");
        studentJson.addProperty("address", "matara");
        studentJson.addProperty("tel", "0715883767");
        String response=new String(studentService.processMessage(studentJson.toString().getBytes()));
        assertThat(response).isEqualTo("oops something wrong");
    }


}
