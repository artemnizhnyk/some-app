package com.artemnizhnyk.someapp.service;

import com.artemnizhnyk.someapp.dto.CatDto;
import com.artemnizhnyk.someapp.entity.Cat;
import com.artemnizhnyk.someapp.mapper.CatMapper;
import com.artemnizhnyk.someapp.repository.CatRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class CatService {

    private final CatRepository catRepository;
    private final CatMapper catMapper = Mappers.getMapper(CatMapper.class);

    public CatDto save(final CatDto catDto) {
        Cat cat = catMapper.toEntity(catDto);
        catRepository.save(cat);
        log.info(String.format("Cat with id \"%d\" and name \"%s\" was saved", cat.getId(), cat.getName()));
        return catMapper.toDto(cat);
    }

    public List<CatDto> findAll() {
        return catRepository.findAll()
                .stream()
                .map(catMapper::toDto)
                .toList();
    }

    public CatDto findById(final Long catId) {
        return catRepository.findById(catId)
                .map(catMapper::toDto)
                .orElse(new CatDto());
    }

    public String delete(final Long catId) {
        if (!catRepository.existsById(catId)) {
            return String.format("Cat with id \"%d\" doesn't exist in DB", catId);
        }
        catRepository.deleteById(catId);
        log.info(String.format("Cat with id \"%d\" was deleted", catId));
        return "Cat was successfully deleted";
    }

    public CatDto update(final CatDto catDto) {
        Optional<Cat> optionalCat = catRepository.findById(catDto.getId());
        Cat cat = optionalCat.orElse(new Cat());
        cat.setName(catDto.getName());
        cat.setAge(catDto.getAge());
        cat.setWeight(catDto.getWeight());
        catRepository.save(cat);
        log.info(String.format("Cat with id \"%d\" and name \"%s\" was updated", cat.getId(), cat.getName()));
        return catMapper.toDto(cat);
    }
}
