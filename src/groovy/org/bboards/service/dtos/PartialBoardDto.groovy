package org.bboards.service.dtos

import org.bboards.service.domains.Photo
import org.bboards.service.domains.Position

/**
 * Created by dshybeka on 24.01.2015.
 */
class PartialBoardDto {
    String id
    Position mapPosition
    BigDecimal price
    String additionalDescription
    Photo dayPhoto
    Photo nightPhoto
}
