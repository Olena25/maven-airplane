package com;

import com.airplane.Airplane;
import com.airplane.AirplaneService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class AirplaneServiceTest {

    private static final Random RANDOM = new Random();

    private final Airplane FIRST_AIRPLANE = generateAirplane(100);
    private final Airplane SECOND_AIRPLANE = generateAirplane(500);
    private final Airplane THIRD_AIRPLANE = generateAirplane(360);

    private AirplaneService airplaneService;
    private List<Airplane> airplanes;
    private Airplane airplane;

    @BeforeEach
    public void setUp(){
        airplaneService = new AirplaneService();
        airplanes = Arrays.asList(FIRST_AIRPLANE, SECOND_AIRPLANE, THIRD_AIRPLANE);
    }
  @Test
    public void sortedAirplaneListShouldReturnSortedAirplanes(){
    List<Airplane> sortedAirplanes = Arrays.asList(FIRST_AIRPLANE, THIRD_AIRPLANE, SECOND_AIRPLANE);
    List<Airplane> expectedAirplanes = airplaneService.sortedAirplaneList(airplanes);
    Assertions.assertEquals(expectedAirplanes,sortedAirplanes);
    }
    @Test
    public void  findAirplaneByFuelConsumptionShouldReturnFoundAirplanes(){
        List<Airplane> foundAirplanes = airplaneService.findAirplaneByFuelConsumption(airplanes,500);
        Assertions.assertEquals(1,foundAirplanes.size());
        Assertions.assertEquals(SECOND_AIRPLANE,foundAirplanes.get(0));

    }


    private Airplane generateAirplane(int fuel) {
        int seats = RANDOM.nextInt(100);
        int distanceFlight = RANDOM.nextInt(10000);
        return new Airplane(seats,fuel,distanceFlight);
    }
}
