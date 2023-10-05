package com.project.dev.flightavailability;

import com.project.dev.flightavailability.model.Flight;
import com.project.dev.flightavailability.model.Info;
import com.project.dev.flightavailability.respository.FlightAvailabilityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalTime;
import java.util.List;

@SpringBootApplication
public class FlightAvailabilityApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlightAvailabilityApplication.class, args);
    }

    @Bean
    CommandLineRunner run(FlightAvailabilityRepository flightAvailabilityRepository) {
        return args -> {
            flightAvailabilityRepository.save(Info.builder()
                    .flightList(List.of(
                            Flight.builder()
                                    .airline("JetBlue")
                                    .departureTime(LocalTime.parse("06:00:00"))
                                    .arrivalTime(LocalTime.parse("09:00:00"))
                                    .build()))
                    .departurePlace("LGA")
                    .arrivalPlace("FLL")
                    .price(233).build());

            flightAvailabilityRepository.save(Info.builder()
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

            flightAvailabilityRepository.save(Info.builder()
                    .flightList(List.of(
                            Flight.builder()
                                    .airline("Delta")
                                    .departureTime(LocalTime.parse("06:00:00"))
                                    .arrivalTime(LocalTime.parse("08:00:00"))
                                    .build(),
                            Flight.builder()
                                    .airline("IAD")
                                    .departureTime(LocalTime.parse("08:00:00"))
                                    .arrivalTime(LocalTime.parse("08:30:00"))
                                    .build(),
                            Flight.builder()
                                    .airline("Delta")
                                    .departureTime(LocalTime.parse("08:30:00"))
                                    .arrivalTime(LocalTime.parse("11:30:00"))
                                    .build()))
                    .departurePlace("LGA")
                    .arrivalPlace("MIA")
                    .price(220).build());

            flightAvailabilityRepository.save(Info.builder()
                    .flightList(List.of(
                            Flight.builder()
                                    .airline("Delta")
                                    .departureTime(LocalTime.parse("06:15:00"))
                                    .arrivalTime(LocalTime.parse("08:30:00"))
                                    .build(),
                            Flight.builder()
                                    .airline("CVG")
                                    .departureTime(LocalTime.parse("08:30:00"))
                                    .arrivalTime(LocalTime.parse("09:15:00"))
                                    .build(),
                            Flight.builder()
                                    .airline("Delta")
                                    .departureTime(LocalTime.parse("09:15:00"))
                                    .arrivalTime(LocalTime.parse("11:45:00"))
                                    .build()))
                    .departurePlace("LGA")
                    .arrivalPlace("MIA")
                    .price(218).build());

            flightAvailabilityRepository.save(Info.builder()
                    .flightList(List.of(
                            Flight.builder()
                                    .airline("United")
                                    .departureTime(LocalTime.parse("06:15:00"))
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
                    .departurePlace("LGA")
                    .arrivalPlace("MIA")
                    .price(289).build());

            flightAvailabilityRepository.save(Info.builder()
                    .flightList(List.of(
                            Flight.builder()
                                    .airline("Continental")
                                    .departureTime(LocalTime.parse("06:30:00"))
                                    .arrivalTime(LocalTime.parse("08:00:00"))
                                    .build(),
                            Flight.builder()
                                    .airline("CLE")
                                    .departureTime(LocalTime.parse("08:00:00"))
                                    .arrivalTime(LocalTime.parse("09:15:00"))
                                    .build(),
                            Flight.builder()
                                    .airline("Continental")
                                    .departureTime(LocalTime.parse("09:15:00"))
                                    .arrivalTime(LocalTime.parse("12:00:00"))
                                    .build()))
                    .departurePlace("LGA")
                    .arrivalPlace("FLL")
                    .price(762).build());

            flightAvailabilityRepository.save(Info.builder()
                    .flightList(List.of(
                            Flight.builder()
                                    .airline("Continental")
                                    .departureTime(LocalTime.parse("06:45:00"))
                                    .arrivalTime(LocalTime.parse("09:30:00"))
                                    .build()))
                    .departurePlace("EWR")
                    .arrivalPlace("MIA")
                    .price(239).build());

        };
    }

}
