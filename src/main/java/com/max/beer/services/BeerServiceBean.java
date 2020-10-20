package com.max.beer.services;

import com.max.beer.domain.Beer;
import com.max.beer.repositories.BeerRepository;
import com.max.beer.web.controller.NotFoundException;
import com.max.beer.web.mappers.BeerMapper;
import com.max.beer.web.model.BeerDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class BeerServiceBean implements BeerService {

    @Autowired
    private BeerRepository beerRepository;

    @Autowired
    private BeerMapper beerMapper;

    @Override
    public BeerDto getById(UUID beerId) {
        return beerMapper.beerToBeerDto(beerRepository.findById(beerId).orElseThrow(NotFoundException::new));
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return beerMapper.beerToBeerDto(beerRepository.save(beerMapper.beerDtoToBeer(beerDto)));
    }

    @Override
    public BeerDto updateBeer(UUID beerId, BeerDto beerDto) {
        Beer beer = beerRepository.findById(beerId).orElseThrow(NotFoundException::new);
        BeanUtils.copyProperties(beerDto, beer);
        beer.setStyle(beerDto.getStyle().name());

        return beerMapper.beerToBeerDto(beerRepository.save(beer));
    }
}
