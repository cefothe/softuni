package com.cefothe.softuni.dto;

import lombok.*;

/**
 * Created by cefothe on 30.04.17.
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    private String name;
}
