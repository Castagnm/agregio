package com.mcas.agregio.park;

import java.util.ArrayList;
import java.util.List;

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

    public List<Park> getParks(Market market) {
        List<Offer> offers = offerService.getOffers(market);

        List<Block> blocks = new ArrayList<>();

        for(Offer offer : offers) {
            blocks.addAll(offer.getBlocks());
        }

        List<Park> parks = new ArrayList<>();

        for(Block block : blocks) {
            parks.addAll(block.getProducers().keySet());
        }
        
        return parks;
    }
    
}
