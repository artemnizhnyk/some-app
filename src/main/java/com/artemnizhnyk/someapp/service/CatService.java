package com.artemnizhnyk.someapp.service;

import com.artemnizhnyk.someapp.dto.CatDto;
import com.artemnizhnyk.someapp.entity.Cat;
import com.artemnizhnyk.someapp.mapper.CatMapper;
import com.artemnizhnyk.someapp.repository.CatRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class CatService {

    private final CatRepository catRepository;
    private final CatMapper catMapper = Mappers.getMapper(CatMapper.class);

    public void saveCat(final CatDto catDto) {
        Cat cat = catMapper.toEntity(catDto);
        catRepository.save(cat);
        log.info(String.format("Cat with id %d and name %s was saved", cat.getId(), cat.getName()));
    }
}
