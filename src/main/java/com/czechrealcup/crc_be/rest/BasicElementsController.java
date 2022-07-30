package com.czechrealcup.crc_be.rest;

import com.czechrealcup.crc_be.persistance.entity.ContinentEntity;
import com.czechrealcup.crc_be.persistance.repository.ContinentRepository;
import com.czechrealcup.crc_be.rest.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@CrossOrigin
public class BasicElementsController {

    @Autowired
    ContinentRepository continentRepository;

    @GetMapping("/continent/{id}")
    public ContinentEntity findContinentByID (@PathVariable long id){
        return continentRepository.findById(id).orElseThrow(NotFoundException::new);
    }

}
