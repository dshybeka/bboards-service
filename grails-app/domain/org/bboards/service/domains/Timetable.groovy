package org.bboards.service.domains

import net.spantree.mongo.types.jodatime.LocalDateTimeType
import org.joda.time.LocalDateTime

class Timetable {

    LocalDateTime startDate

    LocalDateTime endDate

    static mapWith = "mongo"

    static mapping = {
        startDate type: LocalDateTimeType
        endDate type: LocalDateTimeType
    }

    static constraints = {
        startDate nullable: true
        endDate nullable: true
    }

}
