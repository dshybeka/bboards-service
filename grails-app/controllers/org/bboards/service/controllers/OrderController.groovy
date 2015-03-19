package org.bboards.service.controllers

import grails.converters.JSON
import grails.plugin.springsecurity.ReflectionUtils
import grails.plugin.springsecurity.annotation.Secured
import org.bboards.service.controllers.commands.OrderJson
import org.bboards.service.domains.Board
import org.bboards.service.domains.Order
import org.bboards.service.domains.User
import org.bboards.service.domains.enums.OrderType
import org.joda.time.LocalDateTime
import org.joda.time.format.DateTimeFormat

@Secured("IS_AUTHENTICATED_ANONYMOUSLY")
class OrderController {

    @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    def getOrder() {

//        Board board = Board.get("54c7ea5931a671e2fa556976")
//
//        User user = User.get("54ea121e7fcc55f33573801d")
//
//        log.info("New board order")
//
//        Order order = new Order(board: board, customer: user, startDate: LocalDateTime.now(), endDate: LocalDateTime.now().plusMonths(1))

//        order.save()

        log.info("Order saved")

        render Order.getAll() as JSON
    }

    @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    def saveOrder(OrderJson orderJson) {

//        Board board = Board.get("54c7ea5931a671e2fa556976")
//
//        User user = User.get("54ea121e7fcc55f33573801d")
//
//        log.info("New board order")
//
//        Order order = new Order(board: board, customer: user, startDate: LocalDateTime.now(), endDate: LocalDateTime.now().plusMonths(1))

//        order.save()

        log.info("Order saved " + request);

        Order order = new Order(
                boardId: orderJson.boardId,
                customer: orderJson.customer,
                orderType: OrderType.valueOf(orderJson.orderType),
                startDate: DateTimeFormat.forPattern("dd.MM.yyyy").parseLocalDateTime(orderJson.startDate),
                endDate: DateTimeFormat.forPattern("dd.MM.yyyy").parseLocalDateTime(orderJson.endDate)
        )

        order.save();

        render order as JSON
    }
}
