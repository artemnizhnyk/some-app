package com.artemnizhnyk.someapp.entity;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cat {

    private String name;
    private Integer age;
    private Double weight;
}
