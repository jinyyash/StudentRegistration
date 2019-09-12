package com.hsm.service;


import com.hsm.models.Student;

import java.io.IOException;
import java.sql.SQLException;

public interface StudentService {

    byte[] processMessage(byte[] message) throws IOException, SQLException, ClassNotFoundException;
    boolean save(Student student) throws SQLException, ClassNotFoundException, IOException;


}
