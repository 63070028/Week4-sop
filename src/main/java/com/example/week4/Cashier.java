package com.example.week4;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Cashier {

    @RequestMapping(value = "/getChange/{n}")
    public Change getChange(@PathVariable("n") int num){
        Change c = new Change();
        c.setB1000(num/1000);
        c.setB500(num%1000/500);
        c.setB100((num%1000)%500/100);
        c.setB20((((num%1000)%500)%100)/20);
        c.setB10(((((num%1000)%500)%100)%20)/10);
        c.setB5((((((num%1000)%500)%100)%20)%10)/5);
        c.setB1((((((num%1000)%500)%100)%20)%10)%5);
        return c;
    }
}
