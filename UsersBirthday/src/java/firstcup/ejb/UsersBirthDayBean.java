/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstcup.ejb;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import firstcup.entity.JavaUsers;

/**
 *
 * @author nolanof
 */
@Stateless
public class UsersBirthDayBean {

    private static final Logger logger = Logger.getLogger("fistcup.ejb.UsersBirthDayBean");

    @PersistenceContext
    private EntityManager em;

    public Double getAverageAgeDifference() {
        Double aveAgeDiff = (Double) em.createNamedQuery("findAverageAgeDifferenceofAllUsers")
                .getSingleResult();
        logger.info("Average age difference is: " + aveAgeDiff);
        return aveAgeDiff;
    }

    public int getAgeDifference(Date date) {
        int ageDifference;

        Calendar theirBirthday = new GregorianCalendar();
        Calendar javaBirthday = new GregorianCalendar(1995, Calendar.MAY, 23);

        theirBirthday.setTime(date);

        ageDifference = javaBirthday.get(Calendar.YEAR) - theirBirthday.get(Calendar.YEAR);
        logger.info("Raw ageDifference, is: " + ageDifference);

        if (javaBirthday.before(theirBirthday) && (ageDifference > 0)) {
            ageDifference--;
        }
        JavaUsers user = new JavaUsers();
        user.setAgeDifference(ageDifference);
        user.setBirthday(theirBirthday);

        em.persist(user);
        return ageDifference;
    }
}
