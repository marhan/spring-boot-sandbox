package de.marhan.sandbox

import de.marhan.sandbox.domain.City
import groovyx.net.http.RESTClient
import org.springframework.web.client.RestTemplate
import spock.lang.Shared

class CitiesRestSpec extends RestIntegrationBase {

    @Shared
    def client = new RESTClient(serviceURI())

    void "should find many cities"() {
        when:
        def response = client.get(path: "/cities");

        then:
        with(response) {
            status == 200
        }

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

    void "should find searched city"() {
        when:
        City city = new RestTemplate().getForObject(serviceURI("/cities/search/findByNameAndCountryAllIgnoringCase?name=Melbourne&country=Australia"), City)

        then:
        with(city) {
            name == "Melbourne"
            state == "Victoria"
            country == "Australia"
        }
    }

}