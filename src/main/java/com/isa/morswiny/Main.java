package com.isa.morswiny;

import com.isa.morswiny.users.User;

public class Main {
    public static void main(String[] args) {

        //EventCRUDRepository er = new EventCRUDRepository();
        //System.out.println(er.getEventByID(71944));

        UserDataManagement udm = new UserDataManagement();
        for (User user : udm.getUsersSet()) {
            System.out.println(user.toString());

        }
    }
}
