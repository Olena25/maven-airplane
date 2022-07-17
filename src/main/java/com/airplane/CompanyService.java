package com.airplane;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@Data
public class CompanyService {

    private AirplaneService airplaneService;
    private List<Company> companies;

    public List<Airplane> findCompanyAirplanesByFuelConsumption(Company company, int fuelConsumption) {
        if(company == null) {
            return Collections.emptyList();
        }
        return airplaneService.findAirplaneByFuelConsumption(company.getAirplanes(), fuelConsumption);
    }

   public List<String> findCompanyName(int numberOfAirplanes) {
        List<String> namesCompany = new ArrayList<>();
        for (Company company: companies){
            if (company.getAirplanes() != null && numberOfAirplanes == company.getAirplanes().size()){
                namesCompany.add(company.getName());
            }
        }
        return namesCompany;
   }
}
