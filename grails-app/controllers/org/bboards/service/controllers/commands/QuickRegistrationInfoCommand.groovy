package org.bboards.service.controllers.commands

import grails.validation.Validateable

/**
 * Created by dshybeka on 25.02.2015.
 */
@Validateable
class QuickRegistrationInfoCommand {

    String fio
    String email
    String password
    String phone
    String passwordConfirmation

    static constraints = {
        fio size: 1..100, blank: false
        email size: 1..50, email: true, blank: false
        password size: 6..20, blank: false
        passwordConfirmation size: 6..20, blank: false, validator: QuickRegistrationInfoCommand.passwordValidator
        phone size: 6..20, blank: false
    }

    static final def passwordValidator = { value, command ->
        if (command?.password != command?.passwordConfirmation) {
            //returning message code for i18n/messages.properties file
            return 'registerCommand.passwordConfirmation.mismatch'
        }

        true
    }
}
