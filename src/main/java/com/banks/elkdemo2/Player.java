package com.banks.elkdemo2;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player
{

    private String name, position, country;
    private Boolean youngster;

}
