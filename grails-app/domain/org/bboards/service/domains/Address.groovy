package org.bboards.service.domains

import org.bboards.service.domains.enums.Distinct

class Address {

    private String fullAddress;

    private Distinct district;

    static mapWith = "mongo"

    static constraints = {
    }
}
