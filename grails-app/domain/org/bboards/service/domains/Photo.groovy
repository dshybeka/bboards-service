package org.bboards.service.domains

class Photo {

    String path
    String url
    Double width
    Double height

    static mapWith = "mongo"

    static constraints = {
        path nullable: true
        url nullable: true
        width nullable: true
        height nullable: true
    }
}
