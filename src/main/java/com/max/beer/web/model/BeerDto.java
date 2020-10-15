package com.max.beer.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BeerDto {
    private UUID id;
    private Integer version;

    private OffsetDateTime createTs;
    private OffsetDateTime updateTs;

    private String name;

    private BeerStyle style;

    private Long upc;
    private BigDecimal price;

    private Integer quantity;
}
