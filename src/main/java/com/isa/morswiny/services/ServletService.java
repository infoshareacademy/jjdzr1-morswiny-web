package com.isa.morswiny.services;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public class ServletService {


    public static void sessionValidation(HttpServletRequest req, HashMap<String, Object> map) {
        if (req.getSession(false) != null && req.getSession(false).getAttribute("logged") != null){
            map.put("logged", req.getSession().getAttribute("logged"));
        }
    }
}
