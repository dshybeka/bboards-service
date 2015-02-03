package org.bboards.service.dtos

import groovy.transform.ToString
import org.bboards.service.domains.Photo
import org.bboards.service.domains.Position
import org.bboards.service.domains.Timetable

/**
 * Created by dshybeka on 24.01.2015.
 */
@ToString
class PartialBoardDto {
    String id
    Position mapPosition
    BigDecimal price
    String additionalDescription
    List<Timetable> timetables
    Photo dayPhoto
    Photo nightPhoto
}
