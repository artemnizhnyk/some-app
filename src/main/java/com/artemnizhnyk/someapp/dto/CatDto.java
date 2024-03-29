package com.artemnizhnyk.someapp.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CatDto {

    private Long id;
    private String name;
    private Integer age;
    private Double weight;
}
