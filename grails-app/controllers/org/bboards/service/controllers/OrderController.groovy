package org.bboards.service.controllers

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import org.bboards.service.controllers.commands.OrderJson
import org.bboards.service.domains.Board
import org.bboards.service.domains.Order
import org.bboards.service.domains.User
import org.bboards.service.domains.enums.OrderType
import org.bboards.service.dtos.PartialOrderDto
import org.bboards.service.services.OrderService
import org.grails.datastore.mapping.query.api.BuildableCriteria
import org.joda.time.format.DateTimeFormat

@Secured("IS_AUTHENTICATED_ANONYMOUSLY")
class OrderController {

    OrderService orderService;

    @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    def getOrders() {

        render Order.getAll() as JSON;
    }

    @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    def saveOrder(OrderJson orderJson) {

        Order order = new Order(
                board: Board.get(orderJson.boardId),
                customer: User.findByUsername(orderJson.customer),
                orderType: OrderType.valueOf(orderJson.orderType),
                startDate: DateTimeFormat.forPattern("dd.MM.yyyy").parseLocalDateTime(orderJson.startDate),
                endDate: DateTimeFormat.forPattern("dd.MM.yyyy").parseLocalDateTime(orderJson.endDate)
        )

        def startDate = order.getStartDate();
        def endDate = order.getEndDate();

        BuildableCriteria criteria = Order.createCriteria();
        List<Order> orders = criteria.list {
            eq("board", order.getBoard())
        }

        def result = [success: true, model: "Ваш заказ принят"];

        for (Order o : orders) {

            def oStartDate = o.getStartDate();
            def oEndDate = o.getEndDate();
            if (oStartDate.isBefore(startDate) && oEndDate.isAfter(startDate)) {
                result = [success: false, model: "Нельзя оформить заказ на данный период."];
            }

            if (oStartDate.isBefore(endDate) && oEndDate.isAfter(endDate)) {
                result = [success: false, model: "Нельзя оформить заказ на данный период."];
            }

            if (oStartDate.isAfter(startDate) && oEndDate.isBefore(endDate)) {
                result = [success: false, model: "Нельзя оформить заказ на данный период."];
            }
        }

        if (result.success) {

            order.save()
        }


        render result as JSON;
    }

    @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    def getOrdersByBoardId () {

        Board board = Board.get(params.id);

        List<Order> orders = Order.findAllByBoard(board);

        log.debug(String.format("Found %d orders for board %s", orders.size(), params.id));

        def result = [success: true, model: orders.collect { Order order ->
            new PartialOrderDto(
                    startDate: order.getStartDate(),
                    endDate: order.getEndDate()
            )
        }]

        render result as JSON;
    }
}
