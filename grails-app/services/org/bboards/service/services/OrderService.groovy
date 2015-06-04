package org.bboards.service.services

import com.sun.org.apache.xerces.internal.impl.validation.ValidationManager
import grails.validation.ValidationException
import org.bboards.service.domains.Board
import org.bboards.service.domains.Order
import org.grails.datastore.mapping.query.api.BuildableCriteria
import org.joda.time.Days
import org.joda.time.LocalDateTime

/**
 * Created by vbogdanov on 05.04.2015.
 */
class OrderService {

    def saveNewOrder(Order order) {

        validateOrderDates(order);
//        order.save();
    }

    def validateOrderDates(Order order) {

        LocalDateTime startDate = order.getStartDate();
        LocalDateTime endDate = order.getEndDate();

        int minRentDuration = order.getBoard().getMinRentDuration();

        if (Days.daysBetween(startDate, endDate).days < minRentDuration) {
            throw new RuntimeException(
                    String.format("Период аренды должен быть более %d дней",
                            minRentDuration));
        }

        BuildableCriteria criteria = Order.createCriteria();

        List<Order> orders = criteria.list {
            and {
                eq("board", order.getBoard())
//                or {
//                    between("startDate", startDate, endDate)
//                    between("endDate", startDate, endDate)
//                    and {
//                        lt("startDate", startDate)
//                        gt("endDate", endDate)
//                    }
//                }
            }
        }

        if (!orders.isEmpty()) {
            throw new RuntimeException("Борд уже занят в этот период");
        }
    }

}
