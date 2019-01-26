package com.crud.purchases.mapper;

import com.crud.purchases.domain.Thing;
import com.crud.purchases.domain.ThingDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ThingMapper {
    public Thing mapToThing(final ThingDto thingDto) {
        return new Thing(
                thingDto.getId(),
                thingDto.getName(),
                thingDto.getDescription());
    }

    public ThingDto mapToThingDto(final Thing thing) {
        return new ThingDto(
                thing.getId(),
                thing.getName(),
                thing.getDescription());
    }

    public List<ThingDto> mapToThingDtoList(final List<Thing> thingList) {
        return thingList.stream()
                .map(t -> new ThingDto(t.getId(), t.getName(), t.getDescription()))
                .collect(Collectors.toList());
    }
}
