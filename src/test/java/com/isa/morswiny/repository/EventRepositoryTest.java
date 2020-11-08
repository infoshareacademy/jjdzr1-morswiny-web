package com.isa.morswiny.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class EventRepositoryTest {


    @Test
    void getEventRepositoryTest(){

        Assertions.assertDoesNotThrow(EventRepository::getEventRepository);
    }
}
