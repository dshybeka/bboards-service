package org.bboards.service.domains

import grails.converters.JSON

class BoardController {

    def getAllBoards() {

        def result = [success: true, model: Board.getAll()]
        render result as JSON
    }
}
