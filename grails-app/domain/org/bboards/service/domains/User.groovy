package org.bboards.service.domains

import org.bson.types.ObjectId

class User {

	transient springSecurityService

	ObjectId id
	String username
	String password
	boolean enabled = true
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

	Set authorities

	static transients = ['springSecurityService']

	static embedded = ['authorities']

	static mapWith = "mongo"

	static constraints = {
		username blank: false, unique: true, size: 2..32, matches: "[a-zA-z0-9_]+"
		password blank: false
	}

	static mapping = {
		password column: '`password`'
	}

	Set<Role> getAuthorities() {
		UserRole.findAllByUser(this).collect { it.role }
	}

	def beforeInsert() {
		println "start before insert user "
		encodePassword()
//		true
	}

//	def beforeUpdate() {
//		if (isDirty('password')) {
//			encodePassword()
//		}
//	}

	protected void encodePassword() {
		println "ebfore insert is called"
		println "springSecurityService.encodePassword(password) " + springSecurityService.encodePassword(password)
		password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
//		println "password will be like " + password
//		password
	}
}
