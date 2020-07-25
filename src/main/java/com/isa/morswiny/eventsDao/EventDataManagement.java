package com.isa.morswiny.eventsDao;

import com.isa.morswiny.events.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class EventDataManagement {

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");

    public List<Event> createListOfAllEvents(){
        Event[] gsonEvents = new EventDataLoad().getJsonEventData("src/main/resources/events.json");
        List<Event> eventsList = new ArrayList<>(Arrays.asList(gsonEvents));
        //list - trimdatetime
        //list - set local date
        //list - set date
        //list - trimdescription
        //list - sort
        // -
        return eventsList;
    }

    private void trimDateStrings(List<Event> list){
        for (Event event : list){
            if (event.getStartDate() != null){
                event.setStartDate(event.getStartDate().substring(0, 19));
            }
            if (event.getEndDate() != null){
                event.setEndDate(event.getEndDate().substring(0, 19));
            }
        }
    }

    private void setLocalDateTimeInList (List<Event> list) {
        for (Event event : list) {
            if (event.getStartDate() != null) {
                LocalDateTime localDateTime = LocalDateTime.parse(event.getStartDate());
                event.setStartDateLDT(localDateTime);
            }
            if (event.getEndDate() != null) {
                LocalDateTime localDateTime = LocalDateTime.parse(event.getEndDate());
                event.setEndDateLDT(localDateTime);
            }
        }
    }

    private void formatStartEndDate(List<Event> list){

    }

    public static Properties readPropertiesFile() {
        FileInputStream property = null;
        Properties prop = null;
        try {
            property = new FileInputStream("src/main/resources/config.properties");
            prop = new Properties();
            prop.load(property);
        } catch (IOException e) {
            STDOUT.info("Cannot find property file");
        } finally {
            assert property != null;
            try {
                property.close();
            } catch (IOException e) {
                STDOUT.info("Cannot find property file");
            }
        }
        return prop;
    }

    public String dateTimeFormatter(String date) {
        Properties prop = readPropertiesFile();
        String[] dateArray = date.split("T");
        LocalDate eventDate = LocalDate.parse(dateArray[0]);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(prop.getProperty("date.format"));
        String eventDate1 = eventDate.format(dtf);
        return eventDate1 + ", time: " + dateArray[1].substring(0,5);
    }


    public static String trimDescription(String description){
        String noHTMLString = description.replaceAll("\\<.*?>","");
        noHTMLString = noHTMLString.trim();
        return noHTMLString;
    }
}
