package com.airplane;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Airplane passengerPlane = new PassengerAirplane(800,150,3000);
        Airplane privatePlane = new PrivateAirplane(47,700,5000);
        Airplane passengerPlaneRosa = new PassengerAirplane(34,670,4000);
        Airplane privatePlaneRosa = new PrivateAirplane(56,800,7800);
        List<Airplane> airplaneListRosa = Arrays.asList(passengerPlaneRosa,privatePlaneRosa);
        List<Airplane> airplaneListMay = Arrays.asList(passengerPlane,privatePlane);
        List<Airplane> airplaneList = Arrays.asList(passengerPlaneRosa,privatePlaneRosa,passengerPlane,privatePlane);



        Company mayCompany = new MayCompany("May",airplaneListMay);
        Company rosaCompany = new RosaCompany("Rosa",airplaneListRosa);

        AirplaneService airplaneService = new AirplaneService();
        System.out.println("Sort all airplanes by distance: ");
        System.out.println(airplaneService.sortedAirplaneList(airplaneList));

        List<Company> companies =Arrays.asList(mayCompany,rosaCompany);

        CompanyService companyService = new CompanyService(airplaneService, companies);
        System.out.println("Find airplane in May company by fuel consumption: ");
        System.out.println(companyService.findCompanyAirplanesByFuelConsumption(mayCompany,150));

        System.out.println("Find company name by amount airplanes");
        System.out.println(companyService.findCompanyName(2));

    }

}
