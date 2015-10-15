package mr.f.domain

import grails.persistence.Entity
import groovy.transform.ToString


@Entity
@ToString(includeNames = true)
class Person {

    String id

    String firstName
    String lastName

    Address address
}
