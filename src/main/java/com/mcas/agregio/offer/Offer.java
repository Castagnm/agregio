package com.mcas.agregio.offer;

import java.util.List;

import com.mcas.agregio.market.Market;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Offer {

    private final List<Block> blocks;

    private final Market market;
    
}
