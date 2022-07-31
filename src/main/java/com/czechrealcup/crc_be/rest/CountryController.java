package com.czechrealcup.crc_be.rest;

import com.czechrealcup.crc_be.persistance.entity.CountryEntity;
import com.czechrealcup.crc_be.persistance.repository.CountryRepository;
import com.czechrealcup.crc_be.rest.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/country")
@CrossOrigin
public class CountryController {

    @Autowired
    CountryRepository countryRepository;

    @GetMapping("/{id}")
    public CountryEntity findCountryByID (@PathVariable long id){
        return countryRepository.findById(id).orElseThrow(NotFoundException::new);
    }

}
