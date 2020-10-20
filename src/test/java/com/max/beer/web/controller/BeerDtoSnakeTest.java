package com.max.beer.web.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.max.beer.web.model.BeerDto;
import com.max.beer.web.model.BeerStyle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@ActiveProfiles("snake") //Смотрит на имя application-имя.properties
//@ActiveProfiles("upper")
@JsonTest
public class BeerDtoSnakeTest {

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testSnake() throws JsonProcessingException {
        BeerDto beerDto = getValidBeerDto();
        String json = objectMapper.writeValueAsString(beerDto);
        System.out.println(json);
    }

    @Test
    void deserializeTestSnake() throws JsonProcessingException {
        String json  = "{\"version\":null,\"create_ts\":null,\"update_ts\":\"2020-10-20T17:47:14Z\",\"name\":\"My Beer\",\"style\":\"ALE\",\"upc\":12379812987463287,\"price\":\"2.9\",\"quantity\":null,\"beerId\":null}";
        BeerDto beerDto= objectMapper.readValue(json, BeerDto.class);
        System.out.println(beerDto);
    }

    BeerDto getValidBeerDto() {
        return BeerDto.builder()
                .name("My Beer")
                .style(BeerStyle.ALE)
                .createTs(OffsetDateTime.now())
                .updateTs(OffsetDateTime.now())
                .price(new BigDecimal("2.9"))
                .upc(12379812987463287L)
                .build();
    }
}
