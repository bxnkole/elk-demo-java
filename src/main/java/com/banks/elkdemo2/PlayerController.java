package com.banks.elkdemo2;

import javax.servlet.ServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class PlayerController
{

    private final YoungsterService youngsterService;


    @GetMapping("/players/{name}/{position}/{country}/{age}")
    public Player foo(
        ServletRequest req,
        @PathVariable String name,
        @PathVariable String position,
        @PathVariable String country,
        @PathVariable int age
    )
    {
        try
        {
            MDC.put("path", req.getServletContext().getContextPath());
            MDC.put("ip", req.getRemoteAddr());

            MDC.put("name", name);
            MDC.put("position", position);
            MDC.put("country", country);
            MDC.put("age", String.valueOf(age));

            log.info("Request received, start processing");

            Player player = new Player(name, position, country, youngsterService.isYoungster(age));

            log.info("Returning player: " + player);

            return player;
        }
        finally
        {
            MDC.clear();
        }
    }

}