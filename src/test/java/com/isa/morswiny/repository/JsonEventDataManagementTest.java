package com.isa.morswiny.repository;

import com.isa.morswiny.model.Event;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class JsonEventDataManagementTest {

    @Mock
    JsonEventDataManagement jsonEventDataManagement;

    @Test
    void createListOfAllEventsTest() throws IOException {

        List<Event> list = jsonEventDataManagement.createListOfAllEvents("");
        Assertions.assertNotNull(list);

    }

}
