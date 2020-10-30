package com.isa.morswiny.controller;

import com.isa.morswiny.model.Event;
import com.isa.morswiny.services.EventDbLoadService;
import org.apache.http.client.fluent.Request;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


@Path("/load")
@Consumes(MediaType.APPLICATION_JSON)
public class EventRestController {

    @Inject
    EventDbLoadService eventDbLoadService;


    @GET
    public Response save(Event[] events) throws IOException {
        URL urlForGetRequest = new URL("https://planerkulturalny.pl/api/rest/events.json");
         connectToEventsEndPoint(urlForGetRequest);
        return null;
//
//      if (eventDbLoadService.saveEventsFromDto(events)) {
//        return Response.accepted().build();}
//      else {
//          return Response.status(404).build();}
//    }
    }

    private void connectToEventsEndPoint (URL url) throws IOException {
        String readLine = null;
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/json; charset=utf8");
        connection.setRequestProperty("Accept", "application/json");


        int responseCode = connection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            StringBuffer response = new StringBuffer();
            while ((readLine = in.readLine()) != null) {
                response.append(readLine);
            }
            in.close();
            System.out.println("Output is :" + response.toString());
        } else {
            System.out.println("dupa");
        }
    }

    @GET
    public String connect () throws IOException {

        return Request.Get("https://planerkulturalny.pl/api/rest/events.json")
                .connectTimeout(1000)
                .socketTimeout(1000)
                .execute().returnContent().asString();
    }

}
