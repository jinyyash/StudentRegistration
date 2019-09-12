package com.hsm;

import com.hsm.service.StudentService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.sql.SQLException;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TcpServerEndPointTest {
    @MockBean
    private StudentService studentService;

    @Before
    public void setUp() throws SQLException, IOException, ClassNotFoundException {
        String msg="this is a test msg";
        byte [] msgBytes=msg.getBytes();
        when(studentService.processMessage(msgBytes)).thenReturn(msgBytes);

    }

    @Test
    public void whenMsgSendByTcp() throws SQLException, IOException, ClassNotFoundException {
        String msg="this is a test msg";
        byte [] msgBytes=msg.getBytes();
        System.out.println(msgBytes);
        String m=new String(studentService.processMessage(msgBytes));
        Assert.assertEquals(msg,m);

    }
}
