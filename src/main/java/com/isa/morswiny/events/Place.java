package com.isa.morswiny.events;

public class Place {
    private String id;
    private String subname;
    private String name;


    public Place(String id, String subname, String name) {
        this.id = id;
        this.subname = subname;
        this.name = name;
    }

    public Place() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubname() {
        return subname;
    }

    public void setSubname(String subname) {
        this.subname = subname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return " subname : " + subname +
                ", name : " + name;
    }
}
