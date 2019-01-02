package com.banks.elkdemo2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class YoungsterService
{
    boolean isYoungster(int age)
    {
        boolean isYoungster = age <= 30;
        log.info("Player is youngster: " + isYoungster);
        return isYoungster;
    }
}
