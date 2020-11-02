package com.isa.morswiny.services;

import com.isa.morswiny.Dao.EventDao;
import com.isa.morswiny.model.Event;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.*;
import java.util.stream.Collectors;

@RequestScoped
public class EventDbLoadService {

    @Inject
    private EventDao eventDao;


    public void saveEventsFromJson(List<Event> events)  {
//        List<Event> list = new ArrayList<>();
//        List<Event> listOfduplicates = new ArrayList<>();
//        Event event;
//        for  (int i = 0; i<events.size(); i++){
//            event=events.get(i);
//            if (!eventDao.findByJsonId(event.getId())){
//                eventDao.save(event);
//                try{
//                Thread.sleep(1000);}
//                catch (Exception ex){
//                    System.out.println(ex);
//                }
//                list.add(event);
//            } else {
//                listOfduplicates.add(event);
//            }
//
//
//        }
        events.stream()
                .filter(e -> !eventDao.findByJsonId(e.getId()))
                .forEach(e -> eventDao.save(e));


    }

}
