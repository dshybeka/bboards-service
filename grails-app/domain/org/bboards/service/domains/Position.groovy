package org.bboards.service.domains

import org.apache.commons.lang.StringUtils

class Position {

    String lat

    String lng

    Integer zoom

    static mapWith = "mongo"

    static constraints = {
        lat nullable: true
        lng nullable: true
        zoom nullable: true, inList: (5..21).toList()
    }

    Boolean isPresented() {
        StringUtils.isNotEmpty(lat) &&
                StringUtils.isNotEmpty(lng) &&
                zoom != null
    }
}
