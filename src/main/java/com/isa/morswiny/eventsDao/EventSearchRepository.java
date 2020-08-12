package com.isa.morswiny.eventsDao;

import com.isa.morswiny.events.Event;
import com.isa.morswiny.repository.JsonEventDataManagement;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SessionScoped

public class EventSearchRepository implements EventSearchRepositoryInterface, EventCRUDRepositoryInterface, Serializable {
    private List<Event> eventList;



    public void setEventList() {
        JsonEventDataManagement jsonEventDataManagement = new JsonEventDataManagement();
        this.eventList = jsonEventDataManagement.createListOfAllEvents();
    }

    @Override
    public List<Event> searchByString(String userInput) {
        List<Event> list = new ArrayList<>();
        String eventSpecification;
        for (Event event : eventList) {
            eventSpecification = event.returnEventParams();
            if (eventSpecification.toLowerCase()
                    .contains
                            (userInput.toLowerCase())) {
                list.add(event);
            }
        }
        return list;
    }

    @Override
    public List<Event> searchByOrganizer(String organizer) {
        List<Event> list = new ArrayList<>();
        for (Event event : eventList) {
            if (event.getOrganizer().getDesignation().toLowerCase()
                    .contains
                            (organizer.toLowerCase())) {
                list.add(event);
            }
        }
        return list;
    }

    @Override
    public List<Event> searchByPlace(String place) {
        List<Event> list = new ArrayList<>();
        for (Event event : eventList) {
            String nameAndSubname = event.getPlace().getName() + event.getPlace().getSubname();
            if (nameAndSubname.toLowerCase()
                    .contains(
                            place.toLowerCase())) {
                list.add(event);
            }
        }
        return list;
    }

    @Override
    // 1 if active, 0 if inactive
    public List<Event> searchActive(Integer active) {
        List<Event> list = new ArrayList<>();
        for (Event event : eventList) {
            if (event.getActive().equals(active)) {
                list.add(event);
            }
        }
        return list;
    }

    @Override
    public List<Event> searchByName(String name) {
        List<Event> list = new ArrayList<>();
        for (Event event : eventList) {
            if (event.getName().toLowerCase()
                    .contains(
                            name.toLowerCase())) {
                list.add(event);
            }
        }
        return list;
    }

    public Event getEventByID(Integer id) {
        for (Event event : eventList) {
            if (id.equals(event.getId())) {
                return event;
            }
        }
        return new Event();
    }


    @Override
    public boolean isEventExisting(Event event) {
        return false;
    }
}

// method to search for event dates
//    public List<Event> searchByExactDate(String date) {
//        LocalDate queryDate = stringToLocalDate(date);
//
//        List<Event> list = new ArrayList<>();
//        for (Event event : eventList) {
//            LocalDate eventStart = stringToLocalDate(event.getStartDate());
//            LocalDate eventEnd = stringToLocalDate(event.getEndDate());
//            if (eventStart.isBefore(queryDate) && eventEnd.isAfter(queryDate)) {
//                list.add(event);
//            }
//        }
//        return list;
//    }
//
//    // method to search for event dates
//    public List<Event> searchByMonth (String date) {
//        LocalDate queryDate = stringToLocalDate(date);
//        int queryMonth = queryDate.getMonth().getValue();
//        List<Event> list = new ArrayList<>();
//        for (Event event : eventList) {
//            LocalDate eventStart = stringToLocalDate(event.getStartDate());
//            LocalDate eventEnd = stringToLocalDate(event.getEndDate());
//            int startMonth = eventStart.getMonth().getValue();
//            int endMonth = eventEnd.getMonth().getValue();
//            if (startMonth < queryMonth
//                    &&
//                    endMonth >= queryMonth) {
//                list.add(event);
//            }
//        }
//        return list;
//    }


