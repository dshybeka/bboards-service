package org.bboards.service.services

import grails.plugin.springsecurity.SpringSecurityUtils
import grails.plugin.springsecurity.userdetails.GrailsUser
import grails.plugin.springsecurity.userdetails.GrailsUserDetailsService
import org.bboards.service.domains.User
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UsernameNotFoundException

class MongoUserDetailsService implements GrailsUserDetailsService {

    /**
     * Some Spring Security classes (e.g. RoleHierarchyVoter) expect at least one role, so
     * we give a user with no granted roles this one which gets past that restriction but
     * doesn't grant anything.
     */
    static final List NO_ROLES = [new SimpleGrantedAuthority(SpringSecurityUtils.NO_ROLE)]

    @Override
    UserDetails loadUserByUsername(String username, boolean loadRoles) {

        log.debug("Attempted user logon: $username")

        User.withTransaction { status ->
            def user = User.findByUsername(username)

            if (!user) {
                log.warn("User not found: $username")
                throw new UsernameNotFoundException('User not found', username)
            }

            log.debug("User found: $username")

            def roles = NO_ROLES
            if (loadRoles) {
                def authorities = user.authorities?.collect {new SimpleGrantedAuthority(it.authority)}
                if(authorities) {
                    roles = authorities
                }
            }

            if(log.debugEnabled) {
                log.debug("User roles: $roles")
            }

            log.debug "Befre creating grails user!"
            GrailsUser grailsUser = createUserDetails(user, roles)
            log.debug "Grails user is created, return it"
            return grailsUser
        }
    }

    @Override
    UserDetails loadUserByUsername(String username) {
        return loadUserByUsername(username, true)
    }

    protected UserDetails createUserDetails(user, Collection authorities) {
        new GrailsUser(user.username, user.password, user.enabled,
                !user.accountExpired, !user.passwordExpired,
                !user.accountLocked, authorities, user.id)
    }
}