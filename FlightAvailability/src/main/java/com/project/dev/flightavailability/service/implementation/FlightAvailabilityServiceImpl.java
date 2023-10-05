package com.project.dev.flightavailability.service.implementation;

import com.project.dev.flightavailability.model.Flight;
import com.project.dev.flightavailability.model.Info;
import com.project.dev.flightavailability.respository.FlightAvailabilityRepository;
import com.project.dev.flightavailability.service.FlightAvailabilityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FlightAvailabilityServiceImpl implements FlightAvailabilityService {

    private final FlightAvailabilityRepository flightAvailabilityRepository;

    @Override
    public Info saveInfo(Info info) {
        return flightAvailabilityRepository.save(info);
    }

    @Override
    public List<Info> getAllInfo() {
        return flightAvailabilityRepository.findAll();
    }

    @Override
    public List<Info> getInfoByDeptAndArrPlace(String deptPlace, String arrPlace) {
        return flightAvailabilityRepository.findByDeparturePlaceAndArrivalPlace(deptPlace, arrPlace);
    }

    @Override
    public List<Info> getInfoByPriceRange(String deptPlace, String arrPlace, int startPrice, int endPrice) {
        return flightAvailabilityRepository.getInfoByPriceRange(deptPlace, arrPlace, startPrice, endPrice);
    }
}
