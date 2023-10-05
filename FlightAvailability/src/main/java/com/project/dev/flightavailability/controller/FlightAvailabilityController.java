package com.project.dev.flightavailability.controller;

import com.project.dev.flightavailability.model.Info;
import com.project.dev.flightavailability.service.FlightAvailabilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("flight-avail/")
public class FlightAvailabilityController {

    private final FlightAvailabilityService flightAvailabilityService;

    @PostMapping("/save")
    public Info saveInfo(@RequestBody Info info){
        return flightAvailabilityService.saveInfo(info);
    }

    @GetMapping("/all")
    public List<Info> getAllInfo() {
        return flightAvailabilityService.getAllInfo();
    }

    @GetMapping("/place")
    public List<Info> getInfoByDeptAndArrPlace(
            @RequestParam String deptPlace,
            @RequestParam String arrPlace) {
        return flightAvailabilityService.getInfoByDeptAndArrPlace(deptPlace, arrPlace);
    }

    @GetMapping("/price")
    public List<Info> getInfoByPriceRange(
            @RequestParam String deptPlace,
            @RequestParam String arrPlace,
            @RequestParam int startPrice,
            @RequestParam int endPrice) {
        return flightAvailabilityService.getInfoByPriceRange(deptPlace, arrPlace, startPrice, endPrice);
    }
}
