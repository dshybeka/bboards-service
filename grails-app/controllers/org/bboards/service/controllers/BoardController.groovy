package org.bboards.service.controllers

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import org.bboards.service.domains.Board
import org.bboards.service.dtos.PartialBoardDto

@Secured("IS_AUTHENTICATED_ANONYMOUSLY")
class BoardController {

    @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    def health() {
        render "ok"
    }

    @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    def getAllBoards() {

        def boards = Board.getAll()

        def result = [success: true, model: boards.collect { Board board ->
            new PartialBoardDto(id: board.id.toString(),
                                mapPosition: board.mapPosition,
                                price: board.price,
                                additionalDescription: board.additionalDescription,
                                timetables: board.timetables)
        }]
        render result as JSON
    }

    @Secured("ROLE_USER")
    def getBoard() {

        log.info("Retrieve board for id " + params.id)
        Board board = Board.get(params.id)

        def result = [success: true, model: board]

        render result as JSON
    }

    @Secured("ROLE_ROLE_USER")
    def getBoard2() {

        log.info("Retrieve board for id2222 " + params.id)
        Board board = Board.get(params.id)

        def result = [success: true, model: board]

        render result as JSON
    }
}
