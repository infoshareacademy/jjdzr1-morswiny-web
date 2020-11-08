package com.isa.morswiny.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import javax.ws.rs.client.Client;

import static org.easymock.EasyMock.verify;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class EventRestControllerTest {

    @Mock
    Client client;


    @Test
    void restControllerTest(){

    }
}
