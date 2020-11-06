package com.isa.morswiny.parsers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

public class DateTimeParserTest {


    @Test
    void checkDateTimeParser(){

        DateTimeParser dateTimeParser = new DateTimeParser();

        LocalDateTime inputDate = dateTimeParser.setDateFormat("12 August 2020 10:00");
        LocalDateTime expectedDate = LocalDateTime.of(2020, Month.AUGUST, 12, 10, 0);

        Assertions.assertEquals(expectedDate, inputDate);

    }
}
