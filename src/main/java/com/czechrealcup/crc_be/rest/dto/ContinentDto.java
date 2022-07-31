package com.czechrealcup.crc_be.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContinentDto extends RepresentationModel<ContinentDto> {
    private long continentId;
    private String name;
    List<CountrySingleDto> countries;
}
