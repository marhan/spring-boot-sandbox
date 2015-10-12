package de.marhan.sandbox

import de.marhan.sandbox.domain.City
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

class SpringBootSandboxApplication3Spec extends Specification {

    public static final String APPLICATION_ADDRESS = "http://localhost:12345/api"

    void "should return Greetings from Spring Boot!"() {
        when:
        ResponseEntity entity = new RestTemplate().getForEntity(APPLICATION_ADDRESS, String.class)

        then:
        entity.statusCode == HttpStatus.OK
    }

    void "should find application up an runnning"() {
        when:
        ResponseEntity entity = new RestTemplate()
                .getForEntity(APPLICATION_ADDRESS + "/health", String.class)

        then:
        entity.statusCode == HttpStatus.OK
        entity.body == "{\"status\":\"UP\"}"

    }

    void "should find city resource"() {
        when:
        City city = new RestTemplate().getForObject(APPLICATION_ADDRESS + "/cities/2", City)

        then:
        with(city) {
            name == "Melbourne"
            state == "Victoria"
            country == "Australia"
        }
    }

}