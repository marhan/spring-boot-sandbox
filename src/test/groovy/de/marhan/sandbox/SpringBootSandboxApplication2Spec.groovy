package de.marhan.sandbox

import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.boot.test.WebIntegrationTest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.test.context.ContextConfiguration
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

@WebIntegrationTest
@ContextConfiguration(loader = SpringApplicationContextLoader.class)
class SpringBootSandboxApplication2Spec extends Specification {


    void "should return Greetings from Spring Boot!"() {
        when:
        ResponseEntity entity = new RestTemplate().getForEntity("http://localhost:12346", String.class)

        then:
        entity.statusCode == HttpStatus.OK
    }

}