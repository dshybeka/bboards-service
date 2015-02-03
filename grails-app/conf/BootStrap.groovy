import grails.converters.JSON
import org.bboards.service.domains.Role
import org.bboards.service.domains.Timetable
import org.bboards.service.domains.User
import org.bson.types.ObjectId

class BootStrap {

    def init = { servletContext ->

        JSON.registerObjectMarshaller(ObjectId) {
            return it.toStringMongod()
        }

        JSON.registerObjectMarshaller(Timetable) {
            println "parse following Timetable " + it?.startDate + " --> " + it?.endDate
            return [
                    startDate: it?.startDate,
                    endDate: it?.endDate
            ]
        }

//        println "before userrole "
//        User.withTransaction {
//
//            def userRole = new Role(authority:"ROLE_USER").save(flush:true)
//            def user = new User()
//            user.username = "username"
//            user.password = "password"
//            user.enabled = true
//            user.accountExpired = false
//            user.accountLocked = false
//            user.passwordExpired = false
//            user.authorities = [userRole]
//            user.save(flush:true)
////        println "!!!!!!!" + user.errors
//            println "done"
//        }
    }
    def destroy = {
    }
}
