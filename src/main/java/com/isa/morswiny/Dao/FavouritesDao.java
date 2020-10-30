package com.isa.morswiny.Dao;

import com.isa.morswiny.model.Event;

import java.util.Optional;

public class FavouritesDao implements Dao<Event> {


    @Override
    public void save(Event event) {

    }

    @Override
    public Event update(Event event) {
        return null;
    }

    @Override
    public void delete(Event event) {

    }

    @Override
    public Optional<Event> find(Integer id) {
        return Optional.empty();
    }
}
