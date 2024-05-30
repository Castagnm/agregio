package com.mcas.agregio.offer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mcas.agregio.market.Market;

class OfferServiceImplTest {

    private OfferServiceImpl offerService;

    @BeforeEach
    void beforeEach() {
        offerService = new OfferServiceImpl();
    }

    @Test
    void shouldSaveNewOffer() {
        // Given
        Offer offer = buildMockOffer();
        // When
        Offer returnedOffer = offerService.saveOffer(offer);
        // Then
        assertEquals(offer, returnedOffer);
    }

    @Test
    void shouldReturnMarketOffers() {
        // Given
        Offer offer = buildMockOffer();
        offerService.saveOffer(offer);
        // When
        List<Offer> offers = offerService.getOffers(Market.PRIMARY_RESERVE);
        // Then
        assertTrue(offers.stream().anyMatch(e -> e.equals(offer)));
    }
    
    private Offer buildMockOffer() {
        Offer offer = new Offer(1, Market.PRIMARY_RESERVE);
        return offer;
    }
}
