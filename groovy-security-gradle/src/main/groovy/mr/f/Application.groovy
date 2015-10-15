package mr.f

import groovy.util.logging.Slf4j
import mr.f.domain.Address
import mr.f.domain.Person
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

import javax.annotation.PostConstruct

@SpringBootApplication
@Slf4j
class Application {

    static void main(String[] args) {
        SpringApplication.run(Application.class, args)
    }

    @PostConstruct
    void init() {
        Person.deleteAll()

        Person arthur = new Person(firstName: 'Arthur', lastName: 'Dent', address: new Address(planet: 'Earth'))
        Person trillian = new Person(firstName: 'Trillian', lastName: 'McMillan', address: new Address(planet: 'Earth'))
        Person ford = new Person(firstName: 'Ford', lastName: 'Prefect', address: new Address(planet: 'Betelgeuse 5'))

        log.info("Setting up test data")
        arthur.save()
        trillian.save()
        ford.save()

        println "### findAll() ###"
        Person.findAll().each { println it }
        println ""

        println "### findByFirstName(Arthur) ###"
        println Person.findByFirstName("Arthur")
        println ""

        println "### findByAddressPlanet(Earth) ###"
        Person.findByAddress("Earth").each { println it }
        println ""
    }
}
