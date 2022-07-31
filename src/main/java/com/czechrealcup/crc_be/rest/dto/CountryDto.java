package com.czechrealcup.crc_be.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CountryDto extends RepresentationModel<CountryDto> {
    private long countryId;
    private String name;
    private String abbr;
    private String flagUrl;
    private ContinentSingleDto continent;

    //TODO add rest

}
