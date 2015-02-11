/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dukes.webservice;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * REST Web Service
 *
 * @author nolanof
 */
@Path("usersAge")
public class UsersAgeResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of DukesAgeResource
     */
    public UsersAgeResource() {
    }

   /*
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/plain")
    public String getText() {
        // Create a new Calendar for Java's birthday
        Calendar javaBirthday = new GregorianCalendar(1995, Calendar.MAY, 23);
// Create a new Calendar for today
        Calendar now = GregorianCalendar.getInstance();

// Subtract today's year from Java's birth year, 1995
        int javaAge = now.get(Calendar.YEAR) - javaBirthday.get(Calendar.YEAR);
        javaBirthday.add(Calendar.YEAR, javaAge);

// If today's date is before May 23, subtract a year from Java's age
        if (now.before(javaBirthday)) {
            javaAge--;
        }
// Return a String representation of Java's age
        return "" + javaAge;
    }
}
