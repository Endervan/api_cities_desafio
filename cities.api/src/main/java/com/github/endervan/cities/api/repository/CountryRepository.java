package com.github.endervan.cities.api.repository;


import com.github.endervan.cities.api.Countries.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
