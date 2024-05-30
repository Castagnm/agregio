package com.mcas.agregio.block;

import java.util.Map;

import com.mcas.agregio.offer.Offer;
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

    // Each block is associated to only one offer
    private final Offer offer;

    // Each park producer will supply a certain amount of energy. The energy production is in mW
    private final Map<Park, Integer> producers;
}
