package org.bboards.service.domains

import org.bboards.service.domains.enums.Distinct

class Address {

    String fullAddress

    String district

    static mapWith = "mongo"

    static constraints = {
        fullAddress nullable: true
        district nullable: true
    }
}
