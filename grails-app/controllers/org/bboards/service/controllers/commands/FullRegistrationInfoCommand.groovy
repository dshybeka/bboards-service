package org.bboards.service.controllers.commands

import grails.validation.Validateable
import org.bboards.service.domains.UserDetails

/**
 * Created by dshybeka on 10.03.2015.
 */
@Validateable
class FullRegistrationInfoCommand {

    def userService

    String username
    String legalName
    String legalAddress
    String postalAddress
    String currentAccount // текущий счет
    String bank
    String bankNumber
    String unp
    String chefFio
    String under // на основании
    String contactPerson
    String contactPersonPhone
    String contactPersonEmail

    static constraints = {
        legalName size: 1..5, blank: true
        legalAddress size: 1..5, blank: true
        postalAddress size: 1..5, blank: true
        currentAccount size: 1..5, blank: true
        bank size: 1..5, blank: true
        bankNumber size: 1..5, blank: true
        unp size: 1..5, blank: true
        chefFio size: 1..5, blank: true
        under size: 1..5, blank: true
        contactPerson size: 1..5, blank: true
        contactPersonPhone size: 1..5, blank: true
        contactPersonEmail size: 1..50, email: true, blank: true
    }

    def doUpdate() {

        log.debug "contactPersonEmailcontactPersonEmail " + contactPersonEmail + " " + under
        UserDetails userDetails = new UserDetails(
                legalName: legalName,
                legalAddress: legalAddress,
                postalAddress: postalAddress,
                currentAccount: currentAccount,
                bank: bank,
                bankNumber: bankNumber,
                unp: unp,
                chefFio: chefFio,
                contactPerson: contactPerson,
                contactPersonPhone: contactPersonPhone,
                contactPersonEmail: contactPersonEmail,
                under: under
        )

        userService.updateUserToFullRegistered(username, userDetails)
    }
}
