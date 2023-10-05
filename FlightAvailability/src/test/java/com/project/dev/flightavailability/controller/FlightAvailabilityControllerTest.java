package com.project.dev.flightavailability.controller;

import com.project.dev.flightavailability.model.Flight;
import com.project.dev.flightavailability.model.Info;
import com.project.dev.flightavailability.service.FlightAvailabilityService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlightAvailabilityControllerTest {

    @Mock
    private FlightAvailabilityService flightAvailabilityService;

    private FlightAvailabilityController controller;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        controller = new FlightAvailabilityController(flightAvailabilityService);
    }

    @Test
    public void testSaveInfo() {
        Info info = Info.builder()
                .flightList(List.of(
                        Flight.builder()
                                .airline("JetBlue")
                                .departureTime(LocalTime.parse("06:00:00"))
                                .arrivalTime(LocalTime.parse("09:00:00"))
                                .build()))
                .departurePlace("LGA")
                .arrivalPlace("FLL")
                .price(233).build();
        when(flightAvailabilityService.saveInfo(any(Info.class))).thenReturn(info);

        Info savedInfo = controller.saveInfo(info);

        verify(flightAvailabilityService, times(1)).saveInfo(any(Info.class));
        assertEquals(info, savedInfo);
    }

    @Test
    public void testGetAllInfo() {
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
                        .price(289).build());
        when(flightAvailabilityService.getAllInfo()).thenReturn(infoList);

        List<Info> retrievedInfoList = controller.getAllInfo();

        verify(flightAvailabilityService, times(1)).getAllInfo();
        assertEquals(infoList, retrievedInfoList);
    }

    @Test
    public void testGetInfoByDeptAndArrPlace() {
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
                        .price(289).build());
        when(flightAvailabilityService.getInfoByDeptAndArrPlace(deptPlace, arrPlace)).thenReturn(infoList);

        List<Info> retrievedInfoList = controller.getInfoByDeptAndArrPlace(deptPlace, arrPlace);

        verify(flightAvailabilityService, times(1)).getInfoByDeptAndArrPlace(deptPlace, arrPlace);
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
                        .price(289).build());
        when(flightAvailabilityService.getInfoByPriceRange(deptPlace, arrPlace, startPrice, endPrice)).thenReturn(infoList);

        List<Info> retrievedInfoList = controller.getInfoByPriceRange(deptPlace, arrPlace, startPrice, endPrice);

        verify(flightAvailabilityService, times(1)).getInfoByPriceRange(deptPlace, arrPlace, startPrice, endPrice);
        assertEquals(infoList, retrievedInfoList);
    }
}
