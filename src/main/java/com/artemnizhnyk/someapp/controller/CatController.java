package com.artemnizhnyk.someapp.controller;

import com.artemnizhnyk.someapp.dto.CatDto;
import com.artemnizhnyk.someapp.service.CatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class CatController {

    private final CatService catService;
   @PostMapping("/add-cat")
    public void addCat(@RequestBody CatDto catDto) {
        catService.saveCat(catDto);
   }
}
