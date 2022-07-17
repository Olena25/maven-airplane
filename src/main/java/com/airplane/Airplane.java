package com.airplane;

import lombok.*;

@AllArgsConstructor
@Data

public class Airplane implements Comparable<Airplane> {
    private int numberOfSeats;
    private int fuelConsumption;
    private int distanceFlight;

    @Override
    public int compareTo(Airplane o) {
        return fuelConsumption - o.getFuelConsumption();
    }
}
