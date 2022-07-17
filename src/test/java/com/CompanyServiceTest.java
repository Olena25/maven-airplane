package com;

import com.airplane.Airplane;
import com.airplane.AirplaneService;
import com.airplane.Company;
import com.airplane.CompanyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CompanyServiceTest {
    private CompanyService companyService;
    private List<Company> companies;
    private AirplaneService airplaneService;
    private static final Airplane airplane1 = new Airplane(12, 340, 4000);
    private static final Airplane airplane2 = new Airplane(10, 500, 5600);
    private static final Airplane airplane3 = new Airplane(34, 100, 1000);
    private static final List<Airplane> airplanes1 = Arrays.asList(airplane1, airplane2);
    private static final List<Airplane> airplanes2 = Arrays.asList(airplane1, airplane3);
    private static final Company company1 = new Company("Rosa", airplanes1);
    private static final Company company2 = new Company("May",airplanes2);


    @BeforeEach
    public void setUp() {
        airplaneService = Mockito.mock(AirplaneService.class);
        companies = Arrays.asList(company1, company2);
        companyService = new CompanyService(airplaneService, companies);
    }

    @Test
    public void findCompanyAirplanesByFuelConsumptionShouldReturnFoundAirplanes() {
        Mockito.when(airplaneService.findAirplaneByFuelConsumption(company1.getAirplanes(), 500)).thenReturn(Collections.singletonList(airplane2));
        List<Airplane> foundAirplanes = companyService.findCompanyAirplanesByFuelConsumption(company1, 500);
        Assertions.assertEquals(1, foundAirplanes.size());
        Assertions.assertEquals(airplane2, foundAirplanes.get(0));
        Mockito.verify(airplaneService, Mockito.times(1)).findAirplaneByFuelConsumption(company1.getAirplanes(), 500);
    }

    @Test
    public void findCompanyNameShouldReturnFoundCompaniesNames() {
        List<String> foundCompaniesNames = companyService.findCompanyName(2);
        Assertions.assertEquals(2, foundCompaniesNames.size());
        Assertions.assertEquals(Arrays.asList("Rosa", "May"), foundCompaniesNames);
    }
    @Test
    public void findCompanyAirplanesByFuelConsumptionShouldReturnEmptyListWhenCompanyIsNull() {
        List<Airplane> foundAirplanes = companyService.findCompanyAirplanesByFuelConsumption(null, 500);
        Assertions.assertTrue(foundAirplanes.isEmpty());
        Mockito.verify(airplaneService, Mockito.times(0)).findAirplaneByFuelConsumption(Mockito.any(),Mockito.any(Integer.class));
    }
    @Test
    public void findCompanyNameShouldReturnFoundCompaniesNamesWhenCompanyListAirplanesIsNull() {
        Company thirdCompany = new Company("Hulu",null);
        companyService = new CompanyService(airplaneService,Arrays.asList(company1,company2,thirdCompany));
        List<String> foundCompaniesNames = companyService.findCompanyName(2);
        Assertions.assertEquals(2, foundCompaniesNames.size());
        Assertions.assertEquals(Arrays.asList("Rosa", "May"), foundCompaniesNames);
    }
}
