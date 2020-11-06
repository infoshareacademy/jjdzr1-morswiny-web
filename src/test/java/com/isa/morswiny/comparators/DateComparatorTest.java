package com.isa.morswiny.comparators;

import com.isa.morswiny.model.Event;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DateComparatorTest {

    @Test
    void compareTest(){

        Event event1 = new Event();
        Event event2 = new Event();

        event1.setStartDate("12.12.2020");
        event2.setStartDate("12.12.2020");

        DateComparator comparator = new DateComparator();
        int result = comparator.compare(event1, event2);

        Assertions.assertEquals(0, result);
    }
}
