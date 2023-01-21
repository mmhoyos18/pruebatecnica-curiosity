package com.co.pruebaTecnica.repositories;

import com.co.pruebaTecnica.model.LogCountry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogCountryRepository extends JpaRepository<LogCountry,Integer> {

}
