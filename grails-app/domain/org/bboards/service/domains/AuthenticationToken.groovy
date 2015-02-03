package org.bboards.service.domains

class AuthenticationToken {

    String username
    String token

    static mapWith = "mongo"

    static constraints = {
        username nullable: true
        token nullable: true
    }
}
