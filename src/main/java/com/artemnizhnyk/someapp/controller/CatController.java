package com.artemnizhnyk.someapp.controller;

import com.artemnizhnyk.someapp.dto.CatDto;
import com.artemnizhnyk.someapp.service.CatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class CatController {

    private final CatService catService;

    @GetMapping("/cats")
    public List<CatDto> findAll() {
        return catService.findAll();
    }

    @GetMapping("/cat/{cat_id}")
    public CatDto findById(@PathVariable("cat_id") final Long catId) {
        return catService.findById(catId);
    }

    @PostMapping("/cat")
    public CatDto add(@RequestBody CatDto catDto) {
        return catService.save(catDto);
    }

    @PutMapping("/cat")
    public CatDto update(@RequestBody CatDto catDto) {
        return catService.update(catDto);
    }

    @DeleteMapping("/cat/{cat_id}")
    public String deleteById(@PathVariable("cat_id") final Long catId) {
        return catService.delete(catId);
    }
}
