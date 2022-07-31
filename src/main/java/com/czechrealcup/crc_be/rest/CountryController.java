package com.czechrealcup.crc_be.rest;

import com.czechrealcup.crc_be.persistance.entity.CountryEntity;
import com.czechrealcup.crc_be.persistance.repository.CountryRepository;
import com.czechrealcup.crc_be.rest.dto.CountryDto;
import com.czechrealcup.crc_be.rest.dto.mapper.CountryMapper;
import com.czechrealcup.crc_be.rest.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Slf4j
@RestController
@RequestMapping("country")
@CrossOrigin
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    @GetMapping("all")
    public CollectionModel<CountryDto> allCountries (){
        List<CountryDto> countryDtos = countryRepository.findAll().stream().map(CountryMapper::entityToDto).toList();
        for (var countryDto : countryDtos){
            countryDto.getContinent().add(linkTo(ContinentController.class).slash(countryDto.getContinent().getContinentId()).withSelfRel());
            countryDto.add(linkTo(CountryController.class).slash(countryDto.getCountryId()).withSelfRel());
        }

        Link selflink = linkTo(CountryController.class).slash("all").withSelfRel();

        return CollectionModel.of(countryDtos, selflink);
    }

    @GetMapping("{id}")
    public CountryDto findCountryByID (@PathVariable long id){
        CountryDto countryDto = CountryMapper.entityToDto(countryRepository.findById(id).orElseThrow(NotFoundException::new));

        countryDto.getContinent().add(linkTo(ContinentController.class).slash(countryDto.getContinent().getContinentId()).withSelfRel());
        countryDto.add(linkTo(CountryController.class).slash(countryDto.getCountryId()).withSelfRel());

        return countryDto;
    }

}
