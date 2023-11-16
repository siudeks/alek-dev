package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalcController {

    @GetMapping("/{operation}")
    String operation(@PathVariable("operation") String operation) {

        if (operation.contains("+")) {

            String[] parts = operation.split("\\+");
            String part1 = parts[0]; // 004
            int part1AsNumber = Integer.parseInt(part1);
            String part2 = parts[1];
            int part2AsNumber = Integer.parseInt(part2);
            int result = part1AsNumber + part2AsNumber;
            String resultAsString = Integer.toString(result);
            return resultAsString;
        }

        return "nieznana operacja";
    }

}
