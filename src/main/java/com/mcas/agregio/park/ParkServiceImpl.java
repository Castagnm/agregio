package com.mcas.agregio.park;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.mcas.agregio.market.Market;
import com.mcas.agregio.offer.Block;
import com.mcas.agregio.offer.Offer;
import com.mcas.agregio.offer.OfferService;

@Service
public class ParkServiceImpl implements ParkService {

    private final OfferService offerService;

    public ParkServiceImpl(OfferService offerService) {
        this.offerService = offerService;
    }

    
    public int savePark(Park park) {
        return park.getId();
    }

    public Set<Park> getParks(Market market) {
        List<Offer> offers = offerService.getOffers(market);

        List<Block> blocks = new ArrayList<>();
        offers.forEach(e -> blocks.addAll(e.getBlocks()));

        Set<Park> parks = new HashSet<>();
        blocks.forEach(e -> parks.addAll(e.getProducers().keySet()));
        
        return parks;
    }
    
}
