package org.bboards.service.filters

class CorsFilterFilters {

    def filters = {
        all(controller:'*', action:'*') {
            before = {
                def isLocalhost = request.getHeader("Origin").equals("http://localhost:8080") // TODO: move to Config.groovy
                def isBservice = request.getHeader("Origin").contains("bservice-bboards.rhcloud.com")
                if (isLocalhost || isBservice) {
                    response.setHeader("Access-Control-Allow-Origin", "*")
                    response.setHeader('Access-Control-Allow-Methods', 'POST, PUT, GET, HEAD, OPTIONS')
                }
            }
        }
    }
}
