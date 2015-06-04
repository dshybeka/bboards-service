package org.bboards.service.dtos

import groovy.transform.ToString
import org.joda.time.LocalDateTime

/**
 * Created by vbogdanov on 05.04.2015.
 */
@ToString
class PartialOrderDto {

    LocalDateTime startDate;
    LocalDateTime endDate;
}
