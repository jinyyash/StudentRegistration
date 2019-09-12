package com.hsm;

import com.hsm.models.Student;
import com.hsm.repository.StudentRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@Transactional //transactional for roll back transaction after adding
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentRepositoryTest {
 @Autowired
 private StudentRepository studentRepository;

 @Test
 public void whenStudentSaveToDB(){
     Student student=new Student();
     student.setNic("997201423V");
     student.setName("jinadi");
     student.setAddress("matara");
     student.setTel("0715886767");
     Assert.assertEquals(studentRepository.save(student),true);
 }
 @Test(expected = NullPointerException.class)
 public void whenNullObjectSaveToDB(){
     Student student=null;
     studentRepository.save(student);
 }

}
