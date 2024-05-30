package com.mcas.agregio.park;

import java.util.Set;

import com.mcas.agregio.market.Market;

public interface ParkService {
    
    int savePark(Park park);

    Set<Park> getParks(Market market);
}
