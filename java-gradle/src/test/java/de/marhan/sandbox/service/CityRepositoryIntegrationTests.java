package de.marhan.sandbox.service;

import de.marhan.sandbox.Application;
import de.marhan.sandbox.domain.City;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class CityRepositoryIntegrationTests {

    @Autowired
    private CityRepository repository;

    @Test
    public void findsFirstPageOfCities() {
        Page<City> cities = this.repository.findAll(new PageRequest(0, 10));

        assertThat(cities.getTotalElements(), is(greaterThan(20L)));
    }

    @Test
    public void findByNameAndCountry() {
        City city = this.repository.findByNameAndCountryAllIgnoringCase("Melbourne", "Australia");

        assertThat(city, notNullValue());
        assertThat(city.getName(), is(equalTo("Melbourne")));
    }

    @Test
    public void findContaining() {
        Page<City> cities = this.repository
                .findByNameContainingAndCountryContainingAllIgnoringCase("", "UK", new PageRequest(0, 10));

        assertThat(cities.getTotalElements(), is(equalTo(3L)));
    }
}
