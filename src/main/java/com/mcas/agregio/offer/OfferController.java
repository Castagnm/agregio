package com.mcas.agregio.offer;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.mcas.agregio.market.Market;

@RestController
@RequestMapping("/api/offers")
public class OfferController {

    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Offer createOffer(Offer offer) {
        if(offer == null) throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
        return offerService.saveOffer(offer);
    }

    @GetMapping
    public List<Offer> getOffers(Market market) {
        if(market == null) throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
        return offerService.getOffers(market);
    }
    
}
