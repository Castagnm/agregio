package com.mcas.agregio.park;

import java.util.List;

import com.mcas.agregio.market.Market;

public interface ParkService {
    
    int savePark(Park park);

    List<Park> getParks(Market market);
}
