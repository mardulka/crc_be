package com.czechrealcup.crc_be.rest.dto.mapper;

import com.czechrealcup.crc_be.persistance.entity.CountryEntity;
import com.czechrealcup.crc_be.rest.dto.CountryDto;
import com.czechrealcup.crc_be.rest.dto.CountrySingleDto;

public class CountryMapper {

    public static CountryDto entityToDto(CountryEntity country) {
        return CountryDto.builder()
                .countryId(country.getCountryId())
                .name(country.getName())
                .abbr(country.getAbbr())
                .flagUrl(country.getFlagUrl())
                .continent(ContinentMapper.entityToSingleDto(country.getContinent()))
                .build();
    }

    public static CountrySingleDto entityToSingleDto(CountryEntity country) {
        return CountrySingleDto.builder()
                .countryId(country.getCountryId())
                .name(country.getName())
                .abbr(country.getAbbr())
                .flagUrl(country.getFlagUrl())
                .build();
    }

    public static CountryEntity singleDtoToEntity(CountrySingleDto countrySingleDto){
        return CountryEntity.builder()
                .countryId(countrySingleDto.getCountryId())
                .name(countrySingleDto.getName())
                .abbr(countrySingleDto.getAbbr())
                .flagUrl(countrySingleDto.getFlagUrl())
                .build();
    }

    public static CountryEntity dtoToEntity(CountryDto countryDto){
        return CountryEntity.builder()
                .countryId(countryDto.getCountryId())
                .name(countryDto.getName())
                .abbr(countryDto.getAbbr())
                .flagUrl(countryDto.getFlagUrl())
                .continent(ContinentMapper.singleDtoToEntity(countryDto.getContinent()))
                .build();
    }
}
