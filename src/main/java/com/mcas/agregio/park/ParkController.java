package com.mcas.agregio.park;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.mcas.agregio.market.Market;

@RestController
public class ParkController {

    public Park createPark(String name, ProductionType productionType) {
        return new Park(name, productionType);
    }

    public List<Park> getSellingParks(Market market) {
        return new ArrayList<>();
    }
    
}
