package com.max.beer.web.mappers;

import com.max.beer.domain.Beer;
import com.max.beer.web.model.BeerDto;
import org.mapstruct.Mapper;


@Mapper(uses = {DateMapper.class})
public interface BeerMapper {
    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto beerDto);


}
