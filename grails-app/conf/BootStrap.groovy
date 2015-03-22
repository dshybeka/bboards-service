import grails.converters.JSON
import org.bboards.service.domains.Order
import org.bboards.service.domains.Timetable
import org.bson.types.ObjectId
import org.joda.time.LocalDateTime
import org.joda.time.format.DateTimeFormat
import org.joda.time.format.DateTimeFormatter

class BootStrap {

    def init = { servletContext ->

        JSON.registerObjectMarshaller(ObjectId) {
            return it.toStringMongod()
        }

        JSON.registerObjectMarshaller(Timetable) {
            DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd");
            return [
                    startDate: it ?  fmt.print(it.startDate) : null,
                    endDate: it ?  fmt.print(it.endDate) : null
            ]
        }

        JSON.registerObjectMarshaller(LocalDateTime) {
            DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd");
            return it != null ?  fmt.print(it) : null
        }

//        println "before userrole "aaa
//        User.withTransaction {
//
//            def userRole = new Role(authority:"ROLE_USER")
//.save(flush:true)
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
