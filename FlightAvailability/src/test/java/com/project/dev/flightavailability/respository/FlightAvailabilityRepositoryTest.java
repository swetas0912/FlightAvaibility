package com.project.dev.flightavailability.respository;

import com.project.dev.flightavailability.model.Flight;
import com.project.dev.flightavailability.model.Info;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlightAvailabilityRepositoryTest {

    @Mock
    private FlightAvailabilityRepository flightAvailabilityRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindByDeparturePlaceAndArrivalPlace() {
        String deptPlace = "Departure";
        String arrPlace = "Arrival";
        List<Info> infoList = Arrays.asList(Info.builder()
                        .flightList(List.of(
                                Flight.builder()
                                        .airline("JetBlue")
                                        .departureTime(LocalTime.parse("06:00:00"))
                                        .arrivalTime(LocalTime.parse("09:00:00"))
                                        .build()))
                        .departurePlace("LGA")
                        .arrivalPlace("FLL")
                        .price(233).build(),
                Info.builder()
                        .flightList(List.of(
                                Flight.builder()
                                        .airline("United")
                                        .departureTime(LocalTime.parse("06:00:00"))
                                        .arrivalTime(LocalTime.parse("07:30:00"))
                                        .build(),
                                Flight.builder()
                                        .airline("IAD")
                                        .departureTime(LocalTime.parse("07:30:00"))
                                        .arrivalTime(LocalTime.parse("08:30:00"))
                                        .build(),
                                Flight.builder()
                                        .airline("United")
                                        .departureTime(LocalTime.parse("08:30:00"))
                                        .arrivalTime(LocalTime.parse("11:15:00"))
                                        .build()))
                        .departurePlace("JFK")
                        .arrivalPlace("MIA")
                        .price(289).build());; // Create a list of Info objects
        when(flightAvailabilityRepository.findByDeparturePlaceAndArrivalPlace(deptPlace, arrPlace)).thenReturn(infoList);

        List<Info> retrievedInfoList = flightAvailabilityRepository.findByDeparturePlaceAndArrivalPlace(deptPlace, arrPlace);

        verify(flightAvailabilityRepository, times(1)).findByDeparturePlaceAndArrivalPlace(deptPlace, arrPlace);
        assertEquals(infoList, retrievedInfoList);
    }

    @Test
    public void testGetInfoByPriceRange() {
        String deptPlace = "Departure";
        String arrPlace = "Arrival";
        int startPrice = 100;
        int endPrice = 200;
        List<Info> infoList = Arrays.asList(Info.builder()
                        .flightList(List.of(
                                Flight.builder()
                                        .airline("JetBlue")
                                        .departureTime(LocalTime.parse("06:00:00"))
                                        .arrivalTime(LocalTime.parse("09:00:00"))
                                        .build()))
                        .departurePlace("LGA")
                        .arrivalPlace("FLL")
                        .price(233).build(),
                Info.builder()
                        .flightList(List.of(
                                Flight.builder()
                                        .airline("United")
                                        .departureTime(LocalTime.parse("06:00:00"))
                                        .arrivalTime(LocalTime.parse("07:30:00"))
                                        .build(),
                                Flight.builder()
                                        .airline("IAD")
                                        .departureTime(LocalTime.parse("07:30:00"))
                                        .arrivalTime(LocalTime.parse("08:30:00"))
                                        .build(),
                                Flight.builder()
                                        .airline("United")
                                        .departureTime(LocalTime.parse("08:30:00"))
                                        .arrivalTime(LocalTime.parse("11:15:00"))
                                        .build()))
                        .departurePlace("JFK")
                        .arrivalPlace("MIA")
                        .price(289).build());; // Create a list of Info objects
        when(flightAvailabilityRepository.getInfoByPriceRange(deptPlace, arrPlace, startPrice, endPrice)).thenReturn(infoList);

        List<Info> retrievedInfoList = flightAvailabilityRepository.getInfoByPriceRange(deptPlace, arrPlace, startPrice, endPrice);

        verify(flightAvailabilityRepository, times(1)).getInfoByPriceRange(deptPlace, arrPlace, startPrice, endPrice);
        assertEquals(infoList, retrievedInfoList);
    }
}
