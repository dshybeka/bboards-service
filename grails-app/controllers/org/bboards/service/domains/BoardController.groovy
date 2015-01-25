package org.bboards.service.domains

import grails.converters.JSON
import org.bboards.service.dtos.PartialBoardDto

class BoardController {

    def getAllBoards() {

        def boards = Board.getAll()

        def result = [success: true, model: boards.collect { Board board ->
            new PartialBoardDto(id: board.id.toString(), mapPosition: board.mapPosition, price: board.price, additionalDescription: board.additionalDescription)
        }]
        render result as JSON
    }

    def getBoard() {

        Board board = Board.get(params.id)

        def result = [success: true, model: board]

        render result as JSON
    }
}
