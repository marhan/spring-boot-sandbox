package mr.f

import groovy.util.logging.Slf4j
import mr.f.domain.Person
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*

@RestController
@Slf4j
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/persons")
class PersonController {

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Person getPersonById(@PathVariable String id) {
        log.info("getPersonById with parameter $id")
        Person.findById(id)
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(method = RequestMethod.GET)
    List<Person> getAllPersons() {
        log.info("getAllPersons()")
        Person.findAll()
    }

    @RequestMapping(method = RequestMethod.POST)
    Person createPerson(@RequestBody Person newPerson) {
        log.info("createPerson with parameter $newPerson")
        newPerson.id = null
        newPerson.save()
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    Person updatePerson(@PathVariable String id, @RequestBody Person updatedPerson) {
        log.info("updatePerson with parameter $id and $updatedPerson")
        updatedPerson.id = id
        updatedPerson.save()
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    Person removePerson(@PathVariable String id) {
        log.info("removePerson with parameter $id")
        Person.findById(id).delete()
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "/search/byFirstName/{firstName}", method = RequestMethod.GET)
    Person getPersonByFirstName(@PathVariable String firstName) {
        log.info("getPersonByFirstName with parameter $firstName")
        Person.findByFirstName(firstName)
    }
}
