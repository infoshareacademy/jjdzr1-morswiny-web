package com.isa.morswiny.eventsDao;


import com.google.gson.Gson;

import com.isa.morswiny.events.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileReader;
import com.google.gson.stream.JsonReader;

public class EventDataLoad {
    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");


    public Event[] getJsonEventData(String filePath) {

        Gson gson = new Gson();
        JsonReader jsonReader = null;
        try {
            File file = new File(getClass().getClassLoader().getResource("events.json").getFile());
            jsonReader = new JsonReader(new FileReader(file));
        } catch (Exception e) {
            STDOUT.error("Plik nie moze byc znaleziony lub nie jest w formacie JSON. Upewnij sie, ze podales wlasciwe dane.");
        }

        return gson.fromJson(jsonReader, Event[].class);
    }

}
