package com.isa.morswiny.services;

import com.isa.morswiny.Dao.OrganizerDao;
import com.isa.morswiny.Dao.PlaceDao;
import com.isa.morswiny.dto.OrganizerDto;
import com.isa.morswiny.dto.PlaceDto;
import com.isa.morswiny.model.Organizer;
import com.isa.morswiny.model.Place;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;


@RequestScoped
public class PlaceService {

        @Inject
        PlaceDao placeDao;

        private PlaceDto placeToDto (Place place){
            PlaceDto placeToDto = new PlaceDto();
            placeToDto.setName(place.getName());
            placeToDto.setId(place.getId());
            placeToDto.setSubname(place.getSubname());
            return placeToDto;
        }

        private Place dtoToPlace (PlaceDto placeDto) {
            Place place = new Place();
            place.setName(placeDto.getName());
            place.setId(placeDto.getId());
            place.setSubname(placeDto.getSubname());
            return place;
        }

        public PlaceDto savePlace (PlaceDto placeDto) {
            Place place = placeDao.save(dtoToPlace(placeDto));
            return placeToDto(place);
        }
    }



