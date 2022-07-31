package com.czechrealcup.crc_be.rest;

import com.czechrealcup.crc_be.persistance.repository.ContinentRepository;
import com.czechrealcup.crc_be.rest.dto.ContinentDto;
import com.czechrealcup.crc_be.rest.dto.mapper.ContinentMapper;
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
@RequestMapping("continent")
@CrossOrigin
public class ContinentController {

    @Autowired
    private ContinentRepository continentRepository;

    @GetMapping("all")
    public CollectionModel<ContinentDto> allContinents() {
        List<ContinentDto> continentDtoList = continentRepository.findAll().stream().map(ContinentMapper::entityToDto).toList();

        for (var continentDto : continentDtoList) {
            Long continentId = continentDto.getContinentId();
            Link selfLink = linkTo(ContinentController.class).slash(continentId).withSelfRel();
            continentDto.add(selfLink);
            for (var countryDto : continentDto.getCountries()) {
                Long countryID = countryDto.getCountryId();
                Link selfLink2 = linkTo(CountryController.class).slash(countryID).withSelfRel();
                countryDto.add(selfLink2);
            }
        }

        Link link = linkTo(ContinentController.class).slash("all").withSelfRel();

        return CollectionModel.of(continentDtoList, link);
    }

    @GetMapping("{id}")
    public ContinentDto findContinentByID(@PathVariable long id) {
        ContinentDto continentDto = ContinentMapper.entityToDto(continentRepository.findById(id).orElseThrow(NotFoundException::new));
        for (var countryDto : continentDto.getCountries()) {
            Long countryID = countryDto.getCountryId();
            Link selfLink2 = linkTo(CountryController.class).slash(countryID).withSelfRel();
            countryDto.add(selfLink2);
        }

        continentDto.add(linkTo(ContinentController.class).slash(continentDto.getContinentId()).withSelfRel());

        return continentDto;
    }

}
