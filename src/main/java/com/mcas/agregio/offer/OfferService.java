package com.mcas.agregio.offer;

import java.util.List;

import com.mcas.agregio.market.Market;

public interface OfferService {
    
    List<Offer> getOffers(Market market);
}
