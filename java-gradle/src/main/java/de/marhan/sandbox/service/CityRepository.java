package de.marhan.sandbox.service;

import de.marhan.sandbox.domain.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "citys", path = "cities")
interface CityRepository extends PagingAndSortingRepository<City, Long> {

    Page<City> findByNameContainingAndCountryContainingAllIgnoringCase(
            @Param("name") String name,
            @Param("country") String country,
            Pageable pageable);

    City findByNameAndCountryAllIgnoringCase(@Param("name") String name,
                                             @Param("country") String country);

}
