package com.mcas.agregio.park;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParkController {

    public Park createPark(String name, ProductionType productionType) {
        return new Park(name, productionType);
    }
    
}
