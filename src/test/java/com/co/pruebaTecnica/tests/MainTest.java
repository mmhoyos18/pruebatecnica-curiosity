package com.co.pruebaTecnica.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.co.pruebaTecnica.dtos.CountryDto;
import com.co.pruebaTecnica.dtos.Name;
import com.co.pruebaTecnica.services.impl.LogCountryServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class MainTest {
	
	@Autowired
	private LogCountryServiceImpl logCountryServiceImpl;
	
	@Test
	public void primerTest() {
		CountryDto countryDto = new CountryDto();
		Name name = new Name();
		name.setCommon("Colombia");
		countryDto.setArea(0D);
		countryDto.setName(name);
		List<CountryDto> list = new ArrayList<>();
		list.add(countryDto);
		
		list = logCountryServiceImpl.allCountries();
		
		Assertions.assertNotNull(list);
	}
	
	@Test
	public void segundoTest() {
		CountryDto dto = logCountryServiceImpl.getCountryByName("Colombia");
		
		Assertions.assertNotNull(dto);
	}
	
	@Test
	public void tercerTest() {
		CountryDto dto = logCountryServiceImpl.getCountryByName("Fail");
		
		Assertions.assertNull(dto);
	}
	
	@Test
	public void cuartoTest() {
		CountryDto countryDto = new CountryDto();
		countryDto.setPopulation(50882884);
		countryDto.setArea(1141748.0D);
		
		Name name = new Name();
		name.setCommon("Colombia");

		countryDto.setName(name);
		
		CountryDto dto = logCountryServiceImpl.getCountryByName("Colombia");
		
		Assertions.assertEquals(countryDto.getName().getCommon(), dto.getName().getCommon());
	}
	
}
