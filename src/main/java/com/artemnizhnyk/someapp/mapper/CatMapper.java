package com.artemnizhnyk.someapp.mapper;

import com.artemnizhnyk.someapp.dto.CatDto;
import com.artemnizhnyk.someapp.entity.Cat;
import org.mapstruct.Mapper;

@Mapper
public interface CatMapper {
    CatDto toDto(Cat cat);
    Cat toEntity(CatDto catDto);
}
