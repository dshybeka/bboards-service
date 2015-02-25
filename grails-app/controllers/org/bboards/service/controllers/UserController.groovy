package org.bboards.service.controllers

import com.odobo.grails.plugin.springsecurity.rest.token.generation.TokenGenerator
import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import org.bboards.service.controllers.commands.QuickRegistrationInfoCommand
import org.bboards.service.domains.Role
import org.bboards.service.domains.User

@Secured("IS_AUTHENTICATED_ANONYMOUSLY")
class UserController {

    TokenGenerator tokenGenerator

    def register(QuickRegistrationInfoCommand quickRegistrationInfoCommand) {
// TODO: check command object errors
        log.debug("quickRegistrationInfoCommand " + quickRegistrationInfoCommand)

        Boolean isSuccess
        String token = ""

        User newUser = new User(username: quickRegistrationInfoCommand.email,
                email: quickRegistrationInfoCommand.email,
                password: quickRegistrationInfoCommand.password,
                phone: quickRegistrationInfoCommand.phone,
                fio: quickRegistrationInfoCommand.fio)

        newUser.authorities = [Role.findByAuthority("ROLE_USER")]
        User.withTransaction {
            isSuccess = newUser.save(flush: true)
            log.debug("newUser " + newUser.errors)
            if (isSuccess) {
                token = tokenGenerator.generateToken()
                println "token generated " + token
            }
        }

        def resultMap = [success: isSuccess != null, message: ""]
        render resultMap as JSON
    }
}
