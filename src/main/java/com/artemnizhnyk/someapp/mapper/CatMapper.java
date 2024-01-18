package com.artemnizhnyk.someapp.mapper;

import com.artemnizhnyk.someapp.dto.CatDto;
import com.artemnizhnyk.someapp.entity.Cat;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CatMapper {

    CatMapper INSTANCE = Mappers.getMapper(CatMapper.class);

    CatDto toDto(Cat cat);
}
