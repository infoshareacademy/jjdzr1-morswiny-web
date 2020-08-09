package com.isa.morswiny.eventsDao;

import com.isa.morswiny.comparators.DateComparator;
import com.isa.morswiny.events.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

//odpowiedzialnosc klasy - zwroc przeformatowana liste eventow do dalszego procesowania przez logike biznesowa aplikacji


public class EventDataManagement {

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");

    private List<Event> listOfEvents;

    public EventDataManagement() {
        setListOfAllEvents();
    }

    public List<Event> returnListOfAllEvents() {
        return listOfEvents;
    }

    public  List<Event> getListOfEvents() {
        return listOfEvents;
    }

    private void setListOfAllEvents() {
        listOfEvents = initializeListOfEvents();
        formatEvents();
    }

    public List<Event> initializeListOfEvents() {
        Event[] gsonEvents = new EventDataLoad().getJsonEventData();
        return new ArrayList<>(Arrays.asList(gsonEvents));
    }

    // TODO change name of method
    private void formatEvents() {
        trimDateStrings();
        setLocalDateTimeInList();
        formatStartEndDate();
        trimDescription();
        listOfEvents.sort(new DateComparator());
    }

    //method trims given StartDate and EndDate Strings form JSON file so they can be parsed to LocalDateTime
    private void trimDateStrings() {
        for (Event event : listOfEvents) {
            if (event.getStartDate() != null) {
                event.setStartDate(event.getStartDate().substring(0, 19));
            }
            if (event.getEndDate() != null) {
                event.setEndDate(event.getEndDate().substring(0, 19));
            }
        }
    }

    //method sets LocalDateTimes to events from JSON file
    private void setLocalDateTimeInList() {
        for (Event event : listOfEvents) {
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

    //method formats StartDate and EndDate Strings to format form property file
    private void formatStartEndDate() {
        Properties prop = readPropertiesFile();
        DateTimeFormatter dtf;
        try {
            dtf = DateTimeFormatter.ofPattern(prop.getProperty("date.format"));
        } catch (NullPointerException e) {
            STDOUT.error("Property file not found!");
            dtf = DateTimeFormatter.ofPattern("dd MMMM yyyy hh:mm");
        }
        for (Event event : listOfEvents) {
            if (event.getStartDate() != null) {
                event.setStartDate(event.getStartDateLDT().format(dtf));
            }
            if (event.getEndDate() != null) {
                event.setEndDate(event.getEndDateLDT().format(dtf));
            }
        }
    }

    private static Properties readPropertiesFile() {
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

    //method trims descriptions from JSON file
    private void trimDescription() {
        for (Event event : listOfEvents) {
            if (event.getDescLong() != null) {
                event.setDescLong(event.getDescLong().replaceAll("\\<.*?>", ""));
            }
        }
    }

}
