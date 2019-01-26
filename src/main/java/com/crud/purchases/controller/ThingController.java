package com.crud.purchases.controller;

import com.crud.purchases.Exception.ThingNotFoundException;
import com.crud.purchases.domain.ThingDto;
import com.crud.purchases.mapper.ThingMapper;
import com.crud.purchases.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ThingController {

    @Autowired
    DbService dbService;

    @Autowired
    ThingMapper thingMapper;

    @GetMapping("/things")
    public List<ThingDto> getThings() {
        return thingMapper.mapToThingDtoList(dbService.getAllThings());
    }

    @GetMapping("/thing/{id}")
    public ThingDto getThing(@PathVariable("id") Long id) throws ThingNotFoundException {
        return thingMapper.mapToThingDto(dbService.getThing(id).orElseThrow(ThingNotFoundException::new));
    }

    @DeleteMapping("/thing/{id}")
    public void deleteThing(@PathVariable("id") Long id) {
        dbService.deleteThing(id);
    }

    @PutMapping("/thing")
    public ThingDto updateThing(@RequestBody ThingDto thingDto) {
        return thingMapper.mapToThingDto(dbService.saveThing(thingMapper.mapToThing(thingDto)));
    }

    @PostMapping("/thing")
    public void createThing(@RequestBody ThingDto thingDto) {
        dbService.saveThing(thingMapper.mapToThing(thingDto));
    }
}
