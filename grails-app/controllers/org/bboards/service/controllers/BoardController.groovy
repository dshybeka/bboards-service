package org.bboards.service.controllers

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import org.bboards.service.domains.Board
import org.bboards.service.dtos.PartialBoardDto

@Secured()
class BoardController {

    def getAllBoards = {

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

    def getBoard = {

        Board board = Board.get(params.id)

        def result = [success: true, model: board]

        render result as JSON
    }
}
