package com.dfinite.msscbeerservice.web.mappers;

import com.dfinite.model.BeerDto;
import com.dfinite.msscbeerservice.domain.Beer;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMappper {

    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoTobeer(BeerDto beerDto);
}
