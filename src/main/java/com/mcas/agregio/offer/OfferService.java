package com.mcas.agregio.offer;

import java.util.List;

import com.mcas.agregio.market.Market;

public interface OfferService {

    Offer saveOffer(Offer offer);
    
    List<Offer> getOffers(Market market);
}
