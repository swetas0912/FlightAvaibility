package com.project.dev.flightavailability.respository;

import com.project.dev.flightavailability.model.Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightAvailabilityRepository extends JpaRepository<Info, Long> {
    List<Info> findByDeparturePlaceAndArrivalPlace(String deptPlace, String arrPlace);

    @Query("SELECT i FROM Info i WHERE i.departurePlace = :deptPlace " +
            "AND i.arrivalPlace = :arrPlace " +
            "AND i.price BETWEEN :startPrice AND :endPrice")
    List<Info> getInfoByPriceRange(@Param("deptPlace") String deptPlace,
                                   @Param("arrPlace") String arrPlace,
                                   @Param("startPrice") int startPrice,
                                   @Param("endPrice") int endPrice);
}
