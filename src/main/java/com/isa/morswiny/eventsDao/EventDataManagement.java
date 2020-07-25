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
        trimDateStrings(eventsList);//list - trimdatetime
        setLocalDateTimeInList(eventsList);//list - set local date
        formatStartEndDate(eventsList);//list - set date
        trimDescription(eventsList);//list - trimdescription

        return eventsList;
    }

    private static void trimDateStrings(List<Event> list){
        for (Event event : list){
            if (event.getStartDate() != null){
                event.setStartDate(event.getStartDate().substring(0, 19));
            }
            if (event.getEndDate() != null){
                event.setEndDate(event.getEndDate().substring(0, 19));
            }
        }
    }

    private static void setLocalDateTimeInList (List<Event> list) {
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

    private static void formatStartEndDate(List<Event> list){
        Properties prop = readPropertiesFile();
        DateTimeFormatter dtf;
            try {
                dtf = DateTimeFormatter.ofPattern(prop.getProperty("date.format"));
            } catch (NullPointerException e){
                STDOUT.error("Property file not found!");
                dtf = DateTimeFormatter.ofPattern("dd MMMM yyyy hh:mm");
            }
        for (Event event : list){
            if (event.getStartDate() != null){
                event.setStartDate(event.getStartDateLDT().format(dtf));
            }
            if (event.getEndDate() != null){
                event.setEndDate(event.getEndDateLDT().format(dtf));
            }
        }
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

    private static void trimDescription(List<Event> list){
        for (Event event : list){
            event.setDescLong(event.getDescLong().replaceAll("\\<.*?>",""));
        }
    }
}
