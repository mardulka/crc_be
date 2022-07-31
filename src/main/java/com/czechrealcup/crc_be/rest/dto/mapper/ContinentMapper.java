package com.czechrealcup.crc_be.rest.dto.mapper;

import com.czechrealcup.crc_be.persistance.entity.ContinentEntity;
import com.czechrealcup.crc_be.rest.dto.ContinentDto;
import com.czechrealcup.crc_be.rest.dto.ContinentSingleDto;
import org.springframework.stereotype.Component;

@Component
public class ContinentMapper {

    public static ContinentDto entityToDto (ContinentEntity continent){
        return ContinentDto.builder()
                .continentId(continent.getContinentId())
                .name(continent.getName())
                .countries(continent.getCountries().stream().map(CountryMapper::entityToSingleDto).toList())
                .build();
    }

    public static ContinentSingleDto entityToSingleDto (ContinentEntity continent){
        return ContinentSingleDto.builder()
                .continentId(continent.getContinentId())
                .name(continent.getName())
                .build();
    }

    public static ContinentEntity dtoToEntity (ContinentDto continentDto){
        return ContinentEntity.builder()
                .continentId(continentDto.getContinentId())
                .name(continentDto.getName())
                .countries(continentDto.getCountries().stream().map(CountryMapper::singleDtoToEntity).toList())
                .build();
    }

    public static ContinentEntity singleDtoToEntity (ContinentSingleDto continentSingleDto){
        return ContinentEntity.builder()
                .continentId(continentSingleDto.getContinentId())
                .name(continentSingleDto.getName())
                .build();
    }

}
