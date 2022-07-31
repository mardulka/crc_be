package com.czechrealcup.crc_be.rest;

import com.czechrealcup.crc_be.persistance.repository.ContinentRepository;
import com.czechrealcup.crc_be.rest.dto.ContinentDto;
import com.czechrealcup.crc_be.rest.dto.mapper.ContinentMapper;
import com.czechrealcup.crc_be.rest.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("continent")
@CrossOrigin
public class ContinentController {

    @Autowired
    private ContinentRepository continentRepository;




    @GetMapping("all")
    public List<ContinentDto> allContinents (){
        return continentRepository.findAll().stream().map(ContinentMapper::entityToDto).toList();
    }

    @GetMapping("{id}")
    public ContinentDto findContinentByID (@PathVariable long id){
        return ContinentMapper.entityToDto(continentRepository.findById(id).orElseThrow(NotFoundException::new));
    }

}
