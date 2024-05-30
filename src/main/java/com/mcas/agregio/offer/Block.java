package com.mcas.agregio.offer;

import java.util.Map;

import com.mcas.agregio.park.Park;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Block {
    
    // in hours
    private final int timeWindow;

    // in euros 
    private final int floorPrice;

    // Each park producer will supply a certain amount of energy. The energy production is in mW
    private final Map<Park, Integer> producers;
}
