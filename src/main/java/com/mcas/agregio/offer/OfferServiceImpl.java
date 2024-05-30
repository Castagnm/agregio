package com.mcas.agregio.offer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mcas.agregio.market.Market;

@Service
public class OfferServiceImpl implements OfferService {

    private final List<Offer> offers;

    public OfferServiceImpl() {
        offers = new ArrayList<>();
    }

    public Offer saveOffer(Offer offer) {
        offers.add(offer);
        return offer;
    }

    public List<Offer> getOffers(Market market) {
        return offers.stream().filter(e -> e.getMarket().equals(market)).toList();
    }
    
}
