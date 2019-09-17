package com.hsm;

import com.google.gson.JsonObject;
import com.hsm.tcpclient.service.MessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.mockito.Mockito.*;

/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
public class TcpClientApplicationTest
{
    @MockBean
    private MessageService messageService;

    @Test
    public void msgSendToTcpClientGateway() throws IOException, ClassNotFoundException {
        JsonObject student = new JsonObject();
        student.addProperty("nic", "457201423v");
        student.addProperty("name", "jinadee yasiruka");
        student.addProperty("address", "matara");
        student.addProperty("tel", "957201423v");
        ArgumentCaptor valueCapture = ArgumentCaptor.forClass(String.class);

        doNothing().when(messageService).sendMessage(any());

    }
    @Test(expected = Exception.class)
    public void nullObjectSendToTcpClientGateway() {
        doThrow().when(messageService).sendMessage(isNull());
        messageService.sendMessage(null);
    }
}
