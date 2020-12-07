package com.georgedoestechstuff.rest.demo.name.mapper;

import com.georgedoestechstuff.rest.demo.name.endpoint.payload.Name;
import com.georgedoestechstuff.rest.demo.name.endpoint.payload.NameDto;

public class NameMapper {

    public Name convertToEntity(NameDto nameDto) {

        return Name.builder()
                .firstName(nameDto.getFirstName())
                .lastName(nameDto.getLastName())
                .address(nameDto.getAddress())
                .build();
    }

    public NameDto convertToDto(Name name) {

        return NameDto.builder()
                .id(name.getId())
                .firstName(name.getFirstName())
                .lastName(name.getLastName())
                .address(name.getAddress())
                .build();
    }

}
