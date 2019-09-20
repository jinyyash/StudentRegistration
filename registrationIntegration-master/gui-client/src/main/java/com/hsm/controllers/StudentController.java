package com.hsm.controllers;


import com.hsm.tcpclient.service.MessageService;
import com.hsm.tcpclient.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {
    @Autowired
    MessageService messageService;

    @RequestMapping(value = "/addStudent",method =RequestMethod.GET )
    public String addStudent() {
        return "addStudent";
    }

   @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String addStudentToDb(@ModelAttribute Student student){
       System.out.println(student.getName());
        messageService.sendMessage(student);
        return "successful";
    }
}
