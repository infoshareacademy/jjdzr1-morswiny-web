package com.isa.morswiny.cdi;

import javax.enterprise.context.RequestScoped;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Properties;

@RequestScoped
public class EventDaoBean implements EventDao{

    @Override
    public void createEvent(Map<String, String[]> eventParameters) {

    }

    public LocalDateTime setDateFormat(String date){

        String format = "DD MMMM YYYY hh:mm";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
        LocalDateTime dateTime = LocalDateTime.parse(date, dtf);

        return dateTime;
    }
}
