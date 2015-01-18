package org.bboards.service.domains

import org.bboards.service.domains.enums.DisplayZoom

class Position {

    Double lat

    Double lng

    DisplayZoom zoom

    static mapWith = "mongo"

    static constraints = {
        lat nullable: true
        lng nullable: true
        zoom nullable: true
    }
}
