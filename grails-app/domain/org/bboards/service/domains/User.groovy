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

	UserDetails userDetails

	Set<Role> authorities

	static transients = ['springSecurityService']

	static embedded = ['authorities', 'userDetails']

	static mapWith = "mongo"

	static constraints = {
		username blank: false, unique: true, size: 2..32, matches: "[.@a-zA-z0-9_/W]+"
		password blank: false
		userDetails nullable: true
	}

	static mapping = {
		password column: '`password`'
		authorities cascade: 'all-delete-orphan'
		userDetails cascade: 'all-delete-orphan'
	}

//	Set<Role> getAuthorities() {
//		UserRole.findAllByUser(this).collect { it.role }
//	}

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
