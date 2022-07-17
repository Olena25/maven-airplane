package com.airplane;

import lombok.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AirplaneService {

    public List<Airplane> sortedAirplaneList(List<Airplane> airplanes) {
        List<Airplane> sortAirplane = new ArrayList<>(airplanes);
        Collections.sort(sortAirplane);
        return sortAirplane;
    }

    public List<Airplane> findAirplaneByFuelConsumption(List<Airplane> airplanes, int fuelConsumption) {
        List<Airplane> foundAirplanes = new ArrayList<>();

        for (int i = 0; i < airplanes.size(); i++) {
            Airplane airplane =airplanes.get(i);
            if (airplane != null && airplane.getFuelConsumption() == fuelConsumption) {
                foundAirplanes.add(airplane);
            }
        }

        return foundAirplanes;
    }
}
