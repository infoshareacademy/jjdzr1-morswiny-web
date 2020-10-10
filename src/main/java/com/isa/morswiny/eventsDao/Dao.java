package com.isa.morswiny.eventsDao;

public interface Dao <T>{

    public boolean save(T t);
    public boolean update(T t);
    public boolean delete(T t);
    public T find (Integer id);


}
