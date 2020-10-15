package com.isa.morswiny.eventsDao;

import javax.ejb.Local;
import java.util.Optional;

@Local
public interface Dao<T> {

    public void save(T t);

    public T update(T t);

    public void delete(T t);

    public Optional<T> find(Integer id);


}
