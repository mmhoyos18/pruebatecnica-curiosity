package com.co.pruebaTecnica.services;

import com.co.pruebaTecnica.dtos.CountryDto;

import java.util.List;

public interface LogCountryService {

    List<CountryDto> allCountries();

    CountryDto getCountryByName(String name);

}
