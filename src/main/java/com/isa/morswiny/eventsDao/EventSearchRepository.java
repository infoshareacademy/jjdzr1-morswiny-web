package com.isa.morswiny.eventsDao;

import com.infoshareacademy.events.Event;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class EventSearchRepository implements EventSearchRepositoryInterface {
    private Set<Event> eventSet;

    @Override
    public List<Event> searchByString(String userInput) {
        List<Event> list = new ArrayList<>();
        String eventSpecification;
        for (Event event : eventSet) {
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
        for (Event event : eventSet) {
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
        for (Event event : eventSet) {
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
        for (Event event : eventSet) {
            if (event.getActive().equals(active)) {
                list.add(event);
            }
        }
        return list;
    }

    @Override
    public List<Event> searchByName(String name) {
        List<Event> list = new ArrayList<>();
        for (Event event : eventSet) {
            if (event.getName().toLowerCase()
                    .contains(
                            name.toLowerCase())) {
                list.add(event);
            }
        }
        return list;
    }

    // method to search for event dates
//    public List<Event> searchByExactDate(String date) {
//        LocalDate queryDate = stringToLocalDate(date);
//
//        List<Event> list = new ArrayList<>();
//        for (Event event : eventSet) {
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
//        for (Event event : eventSet) {
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

}
