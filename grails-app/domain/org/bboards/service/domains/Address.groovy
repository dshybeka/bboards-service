package org.bboards.service.domains

class Address {

    String fullAddress

    String district

    static mapWith = "mongo"

    static constraints = {
        fullAddress nullable: true
        district nullable: true
    }
}
