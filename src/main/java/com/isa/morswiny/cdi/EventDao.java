package com.isa.morswiny.cdi;

import java.time.LocalDateTime;
import java.util.Map;

public interface EventDao {

    void createEvent(Map<String, String[]> eventParameters);
    LocalDateTime setDateFormat(String startDate);
}
