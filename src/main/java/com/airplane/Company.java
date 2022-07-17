package com.airplane;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Company {
    private String name;
    private List<Airplane> airplanes;
}

