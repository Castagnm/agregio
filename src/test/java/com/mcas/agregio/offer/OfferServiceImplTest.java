package com.mcas.agregio.offer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mcas.agregio.market.Market;
import com.mcas.agregio.park.Park;
import com.mcas.agregio.park.ProductionType;

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
        String parkName = "SunPower";
        Park park = new Park(Objects.hash(parkName), parkName, ProductionType.SOLAR);
        Map<Park, Integer> producers = new HashMap<>();
        producers.put(park, 300);
        Block block = new Block(5, 50, producers);
        Offer offer = new Offer(List.of(block), Market.PRIMARY_RESERVE);
        return offer;
    }
}
