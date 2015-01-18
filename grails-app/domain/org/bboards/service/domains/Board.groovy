package org.bboards.service.domains

import org.bboards.service.domains.enums.Surface
import org.bson.types.ObjectId

class Board {

    ObjectId id

    String boardFormat

    Address address

    String dayPhotoUrl

    String sides

    String sideDirections

    String nightPhotoUrl

    Surface surface

    String range

    String weekdayFlow

    String dayOffFlow

    Owner owner

    Long minRentDuration // TODO: hrs?

    BigDecimal installationPrice

    Timetable timetables

    String notes

    String additionalDescription

    BigDecimal price

    Boolean isBacklight

    Boolean crossroads

    Boolean stops

    String entertainmentCenters

    Boolean trafficLlight

    Boolean pedestrianCrossings

    Boolean narrowArea

    Position mapPosition

    static embedded = ['timetables', 'mapPosition']

    static mapWith = "mongo"

    static mapping = {
        mapPosition cascade: "save-update,delete"
    }

    static constraints = {
        boardFormat nullable: true
        address nullable: true
        dayPhotoUrl nullable: true
        sides nullable: true
        sideDirections nullable: true
        nightPhotoUrl nullable: true
        surface nullable: true
        installationPrice nullable: true

        range nullable: true

        weekdayFlow nullable: true

        dayOffFlow nullable: true

        owner nullable: true

        minRentDuration nullable: true

        installationPrice nullable: true

        timetables nullable: true

        notes nullable: true

        additionalDescription nullable: true

        price nullable: true

        isBacklight nullable: true

        crossroads nullable: true

        stops nullable: true

        entertainmentCenters nullable: true

        trafficLlight nullable: true

        pedestrianCrossings nullable: true

        narrowArea nullable: true

        mapPosition nullable: true
    }
}
