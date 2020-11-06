package com.isa.morswiny.mailService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {

    @Mock
    private Service service;


    @Test
    void sendEmailTest(){

        Map<String, String> data = new HashMap<>();

        String subject = "Some subject";
        String body = "Some contents.";
        String recipient = "test@test.com";
        data.put("subject", subject);
        data.put("body", body);
        data.put("recipient", recipient);

        when(service.send(any(Map.class))).thenReturn(true);
        boolean result = service.send(data);

        Assertions.assertTrue(result);

    }

}
