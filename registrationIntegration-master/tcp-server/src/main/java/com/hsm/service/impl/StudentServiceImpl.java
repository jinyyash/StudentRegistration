package com.hsm.service.impl;

import com.hsm.codette.DecodeJson;
import com.hsm.models.Student;
import com.hsm.models.User;
import com.hsm.repository.StudentRepository;
import com.hsm.service.StudentService;
import com.hsm.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;

@Service
public class StudentServiceImpl implements StudentService {

    private final static org.apache.logging.log4j.Logger LOGGER= LogManager.getLogger(StudentServiceImpl.class);

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    UserService userService;

    @Autowired
    DecodeJson decodeJson;

    @Override
    public byte[] processMessage(byte[] message) throws IOException, SQLException, ClassNotFoundException {
        String messageContent = new String(message);
        boolean sucess= false;
        String msg="";
        LOGGER.info("Receive message: {}", messageContent);
        if(message.length>10){
            Student student = decodeJson.decodeJsonToStudent(messageContent);
            sucess = save(student);
            if(sucess){
                msg="student added sucessfully";
            }else{
                msg="oops something wrong"; }
        }else{
            User user= userService.findByUsername(messageContent);
            if(user!=null){
                msg=decodeJson.decodeUserToJson(user);
            }else{
                msg="";
            }

        }

        return msg.getBytes();
    }

    @Override
    public boolean save(Student student) throws SQLException, ClassNotFoundException, IOException {
        return studentRepository.save(student);
    }

}
