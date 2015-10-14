package de.marhan.sandbox

import de.marhan.sandbox.domain.City
import org.springframework.boot.test.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate

class SpringBootSandboxApplication3Spec extends RestIntegrationBase {

    void "should return Greetings from Spring Boot!"() {
        when:
        ResponseEntity entity = new TestRestTemplate().getForEntity(serviceURI(), String.class)

        then:
        entity.statusCode == HttpStatus.OK
    }

    void "should find application up an runnning"() {
        when:
        ResponseEntity entity = new RestTemplate()
                .getForEntity(serviceURI("/health"), String.class)

        then:
        entity.statusCode == HttpStatus.OK
        entity.body == "{\"status\":\"UP\"}"

    }

    void "should find city resource"() {
        when:
        City city = new RestTemplate().getForObject(serviceURI("/cities/2"), City)

        then:
        with(city) {
            name == "Melbourne"
            state == "Victoria"
            country == "Australia"
        }
    }

}