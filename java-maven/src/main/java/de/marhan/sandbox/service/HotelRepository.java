package de.marhan.sandbox.service;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import de.marhan.sandbox.domain.City;
import de.marhan.sandbox.domain.Hotel;

@RepositoryRestResource(collectionResourceRel = "hotels", path = "hotels")
interface HotelRepository extends PagingAndSortingRepository<Hotel, Long> {

    Hotel findByCityAndName(City city, String name);

}
