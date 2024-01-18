package com.artemnizhnyk.someapp.controller;

import com.artemnizhnyk.someapp.dto.CatDto;
import com.artemnizhnyk.someapp.entity.Cat;
import com.artemnizhnyk.someapp.mapper.CatMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class MainController {

    private final ObjectMapper objectMapper;
    private final CatMapper catMapper;

    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/cat")
    public String getCat() {
        CatDto catDto = CatDto.builder()
                .name("Tom")
                .age(5)
                .weight(6.5)
                .build();
        String jsonData = null;
        try {
            jsonData = objectMapper.writeValueAsString(catDto);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return jsonData;
    }

    @PostMapping("/cat")
    public String getSpecificCat(@RequestParam("cat_name") final String catName) {
        CatDto catDto = CatDto.builder()
                .name(catName)
                .age(5)
                .weight(6.5)
                .build();
        String jsonData = null;
        try {
            jsonData = objectMapper.writeValueAsString(catDto);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return jsonData;
    }
}
