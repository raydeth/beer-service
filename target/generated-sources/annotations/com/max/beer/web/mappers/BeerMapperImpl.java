package com.max.beer.web.mappers;

import com.max.beer.domain.Beer;
import com.max.beer.web.model.BeerDto;
import com.max.beer.web.model.BeerStyle;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-10-15T00:35:39+0600",
    comments = "version: 1.4.0.Final, compiler: javac, environment: Java 11.0.8 (Oracle Corporation)"
)
@Component
public class BeerMapperImpl implements BeerMapper {

    @Autowired
    private DateMapper dateMapper;

    @Override
    public BeerDto beerToBeerDto(Beer beer) {
        if ( beer == null ) {
            return null;
        }

        BeerDto beerDto = new BeerDto();

        beerDto.setId( beer.getId() );
        if ( beer.getVersion() != null ) {
            beerDto.setVersion( beer.getVersion().intValue() );
        }
        beerDto.setCreateTs( dateMapper.asOffsetDateTime( beer.getCreateTs() ) );
        beerDto.setUpdateTs( dateMapper.asOffsetDateTime( beer.getUpdateTs() ) );
        beerDto.setName( beer.getName() );
        if ( beer.getStyle() != null ) {
            beerDto.setStyle( Enum.valueOf( BeerStyle.class, beer.getStyle() ) );
        }
        beerDto.setUpc( beer.getUpc() );
        beerDto.setPrice( beer.getPrice() );

        return beerDto;
    }

    @Override
    public Beer beerDtoToBeer(BeerDto beerDto) {
        if ( beerDto == null ) {
            return null;
        }

        Beer beer = new Beer();

        beer.setId( beerDto.getId() );
        if ( beerDto.getVersion() != null ) {
            beer.setVersion( beerDto.getVersion().longValue() );
        }
        beer.setCreateTs( dateMapper.asTimestamp( beerDto.getCreateTs() ) );
        beer.setUpdateTs( dateMapper.asTimestamp( beerDto.getUpdateTs() ) );
        beer.setName( beerDto.getName() );
        if ( beerDto.getStyle() != null ) {
            beer.setStyle( beerDto.getStyle().name() );
        }
        beer.setUpc( beerDto.getUpc() );
        beer.setPrice( beerDto.getPrice() );

        return beer;
    }
}
