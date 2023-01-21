package com.co.pruebaTecnica.services.impl;

import com.co.pruebaTecnica.dtos.CountryDto;
import com.co.pruebaTecnica.model.LogCountry;
import com.co.pruebaTecnica.repositories.LogCountryRepository;
import com.co.pruebaTecnica.services.LogCountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class LogCountryServiceImpl implements LogCountryService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LogCountryRepository repository;

    @Override
    public List<CountryDto> allCountries() {
       CountryDto[] country=restTemplate.getForObject(
               "https://restcountries.com/v3.1/all",
               CountryDto[].class);

       List<CountryDto> listCountry= Arrays.asList(country);

        return listCountry;
    }

    @Override
    public CountryDto getCountryByName(String name) {
        CountryDto[] country=null;
        LogCountry logCountry=new LogCountry();
        try {
            country=restTemplate.getForObject(
                    "https://restcountries.com/v3.1/name/"+name,
                    CountryDto[].class);
            logCountry.setDescripcion("Consulta Exitosa del Pais: " + name);
            logCountry.setFecha(new Date());
            repository.save(logCountry);

        }catch (Exception e){
            logCountry.setDescripcion("Error al consultar el pais: "+ name);
            logCountry.setFecha(new Date());
            repository.save(logCountry);
            return null;
        }
         if (country!=null){
             List<CountryDto> listCountry= Arrays.asList(country);
             if (listCountry!=null && listCountry.size()>0){
                 return listCountry.get(0);
             }else {
                 return null;
             }
         }else {
             return null;
         }

    }
}
