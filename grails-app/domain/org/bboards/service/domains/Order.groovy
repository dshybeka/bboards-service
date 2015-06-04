package org.bboards.service.domains

import net.spantree.mongo.types.jodatime.LocalDateTimeType
import org.bboards.service.domains.enums.OrderType
import org.bson.types.ObjectId
import org.joda.time.LocalDateTime

class Order {

    ObjectId id

    Board board

    User customer

    LocalDateTime startDate
    LocalDateTime endDate

    OrderType orderType

    static mapWith = "mongo"

    static mapping = {
        startDate type: LocalDateTimeType
        endDate type: LocalDateTimeType
    }

    static constraints = {
        startDate nullable: false
        endDate nullable: false
    }

    static hasOne = {
        board: Board
        user: User
    }
}
