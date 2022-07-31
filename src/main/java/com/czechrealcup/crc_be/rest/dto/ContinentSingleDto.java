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
public class ContinentSingleDto extends RepresentationModel<ContinentSingleDto> {
    private long continentId;
    private String name;
}
