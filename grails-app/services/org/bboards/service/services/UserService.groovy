package org.bboards.service.services

import grails.transaction.Transactional
import org.bboards.service.domains.User
import org.bboards.service.domains.UserDetails
import org.bboards.service.dtos.enums.UserStatus

@Transactional
class UserService {

    def updateUserToFullRegistered(String username, UserDetails userDetails) {

        log.debug("Update user to full registration: $username")

        def result = [:]

        def userFromDb = User.findByUsername(username)
log.debug("following user details savw: " + userDetails)
        userDetails.userStatus = UserStatus.FULLY_REGISTERED
        userFromDb.userDetails = userDetails

        def savedSuccess = userFromDb.save(flush: true)
        if (savedSuccess) {
            result.success = true
            result.model = userFromDb
        } else {
            result.success = false
            log.debug " Errors while saving full reg info: " + userFromDb.errors + " | " + userFromDb.userDetails.errors
        }

        return result
    }
}
