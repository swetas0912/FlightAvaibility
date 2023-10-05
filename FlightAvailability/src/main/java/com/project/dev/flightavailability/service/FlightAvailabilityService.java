package com.project.dev.flightavailability.service;

import com.project.dev.flightavailability.model.Info;
import com.project.dev.flightavailability.respository.FlightAvailabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalTime;
import java.util.*;

public interface FlightAvailabilityService {

    Info saveInfo(Info info);
    List<Info> getAllInfo();
    List<Info> getInfoByDeptAndArrPlace(String deptPlace, String arrPlace);
    List<Info> getInfoByPriceRange(String deptPlace, String arrPlace, int startPrice, int endPrice);
}
