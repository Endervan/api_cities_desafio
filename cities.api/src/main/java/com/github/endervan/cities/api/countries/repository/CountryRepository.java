package com.github.endervan.cities.api.countries.repository;


import com.github.endervan.cities.api.countries.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
