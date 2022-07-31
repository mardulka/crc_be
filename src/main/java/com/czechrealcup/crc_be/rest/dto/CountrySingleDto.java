package com.czechrealcup.crc_be.rest.dto;

import com.czechrealcup.crc_be.rest.CountryController;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CountrySingleDto extends RepresentationModel<CountrySingleDto> {
    private long countryId;
    private String name;
    private String abbr;
    private String flagUrl;
}
