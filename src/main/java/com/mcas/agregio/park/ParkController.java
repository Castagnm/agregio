package com.mcas.agregio.park;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.mcas.agregio.market.Market;

@RestController
@RequestMapping("/api/parks")
public class ParkController {

    private ParkService parkService;

    public ParkController(ParkService parkService) {
        this.parkService = parkService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public int createPark(@RequestBody Park park) {
        if(park == null) throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
        return parkService.savePark(park);
    }

    @GetMapping
    public List<Park> getSellingParks(@RequestParam Market market) {
        if(market == null) throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
        return parkService.getParks(market);
    }
    
}
