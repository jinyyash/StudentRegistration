package com.hsm.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.hsm.models.Student;
import com.hsm.repository.StudentRepository;
import com.hsm.service.StudentService;
import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;

@Service
public class StudentServiceImpl implements StudentService {

    private final static org.apache.logging.log4j.Logger LOGGER= LogManager.getLogger(StudentServiceImpl.class);

    @Autowired
    StudentRepository studentRepository;
    @Override
    public byte[] processMessage(byte[] message) throws IOException, SQLException, ClassNotFoundException {
        String messageContent = new String(message);
        int sucess= 0;
        LOGGER.info("Receive message: {}", messageContent);
        ObjectMapper mapper=new ObjectMapper();
        Student student = mapper.readValue(messageContent, Student.class);
        sucess = save(student);
        String msg=" ___________________";

        if(sucess>0){
            msg="student added sucessfully";
       }else{
            msg="oops something wrong";

        }
        return msg.getBytes();
    }

    @Override
    public int save(Student student) throws SQLException, ClassNotFoundException, IOException {
        return studentRepository.save(student);
    }

}
