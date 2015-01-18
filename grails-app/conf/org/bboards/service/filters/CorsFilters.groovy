package org.bboards.service.filters

class CorsFilters {

    def filters = {
        all(controller:'*', action:'*') {
            before = {

                log.debug "Regust origin header is " + request.getHeader("Origin")

                def isLocalhost = request.getHeader("Origin")?.equals("http://localhost:8080") // TODO: move to Config.groovy
                def isBservice = request.getHeader("Origin")?.contains("bfront-bboards.rhcloud.com")
                if (isLocalhost || isBservice) {
                    log.debug "Set header Access-Control-Allow-Origin"
                    response.setHeader("Access-Control-Allow-Origin", "*")
                    response.setHeader('Access-Control-Allow-Methods', 'POST, PUT, GET, HEAD, OPTIONS')
                }
            }
        }
    }
}
