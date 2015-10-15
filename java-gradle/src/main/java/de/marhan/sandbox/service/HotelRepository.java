package de.marhan.sandbox.service;

import de.marhan.sandbox.domain.City;
import de.marhan.sandbox.domain.Hotel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "hotels", path = "hotels")
interface HotelRepository extends PagingAndSortingRepository<Hotel, Long> {

    Hotel findByCityAndName(City city, String name);

}
