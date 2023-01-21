package com.co.pruebaTecnica.rest;

import com.co.pruebaTecnica.dtos.CountryDto;
import com.co.pruebaTecnica.services.impl.LogCountryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@CrossOrigin("*")
public class MainRest {

    @Autowired
    private LogCountryServiceImpl service;

    @GetMapping(path = "/helpcheck", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> servicioArriba() {
        return new ResponseEntity<>("Estoy funcionando !!", HttpStatus.OK);
    }

    @GetMapping(path = "/getAllCountries", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllCountries() {
        return new ResponseEntity<>(service.allCountries(), HttpStatus.OK);
    }

    @GetMapping(path = "/getCountryByName", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCountryByName(@RequestParam String name) {
        CountryDto country=service.getCountryByName(name);
        if (country!=null){
            return new ResponseEntity<>(country, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("El pais "+ name + " no existe", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
