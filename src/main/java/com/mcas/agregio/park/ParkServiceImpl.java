package com.mcas.agregio.park;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.mcas.agregio.block.Block;
import com.mcas.agregio.block.BlockService;
import com.mcas.agregio.market.Market;

@Service
public class ParkServiceImpl implements ParkService {

    private final List<Park> parks;

    private final BlockService blockService;

    public ParkServiceImpl(BlockService blockService) {
        this.blockService = blockService;
        this.parks = new ArrayList<>();
    }

    
    public int savePark(Park park) {
        parks.add(park);
        return park.getId();
    }

    public Set<Park> getParks(Market market) {
        List<Block> blocks = blockService.getBlocks(market);

        Set<Park> matchingParks = new HashSet<>();
        blocks.forEach(e -> parks.addAll(e.getProducers().keySet()));
        
        return matchingParks;
    }
    
}
