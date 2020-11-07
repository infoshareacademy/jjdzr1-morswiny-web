package com.isa.morswiny.Dao;

import com.isa.morswiny.model.Event;

import java.util.Optional;

public interface Dao<T> {

    public T save(T t);

    public T update(T t);

    public void delete(T t);

    public Optional<T> find(Integer id);


}
