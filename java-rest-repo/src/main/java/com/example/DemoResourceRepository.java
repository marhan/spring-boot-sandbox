package com.example;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface DemoResourceRepository extends PagingAndSortingRepository<DemoResource, Long> {

    List<DemoResource> findByContent(@Param("content") String content);

}
