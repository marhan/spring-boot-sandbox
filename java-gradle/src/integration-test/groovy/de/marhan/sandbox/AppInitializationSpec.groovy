package de.marhan.sandbox

import org.springframework.boot.test.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate

class AppInitializationSpec extends RestIntegrationBase {

    void "should find app"() {
        when:
        ResponseEntity entity = new TestRestTemplate().getForEntity(serviceURI(), String.class)

        then:
        entity.statusCode == HttpStatus.OK
    }

    void "should find application up an running"() {
        when:
        ResponseEntity entity = new RestTemplate()
                .getForEntity(serviceURI("/health"), String.class)

        then:
        entity.statusCode == HttpStatus.OK
        entity.body == "{\"status\":\"UP\"}"

    }

    void "should find application metrics"() {
        when:
        ResponseEntity entity = new RestTemplate()
                .getForEntity(serviceURI("/metrics"), String.class)

        then:
        entity.statusCode == HttpStatus.OK
    }

}