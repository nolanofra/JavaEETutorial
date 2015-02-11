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
import firstcup.entity.FirstcupUser;

/**
 *
 * @author nolanof
 */
@Stateless
public class DukesBirthDayBean {

    private static final Logger logger = Logger.getLogger("fistcup.ejb.DukesBirthDayBean");

    @PersistenceContext
    private EntityManager em;

    public Double getAverageAgeDifference() {
        Double aveAgeDiff = (Double) em.createNamedQuery("findAverageAgeDifferenceofAllFirstCupUsers")
                .getSingleResult();
        logger.info("Average age difference is: " + aveAgeDiff);
        return aveAgeDiff;
    }

    public int getAgeDifference(Date date) {
        int ageDifference;

        Calendar theirBirthday = new GregorianCalendar();
        Calendar dukesBirthday = new GregorianCalendar(1995, Calendar.MAY, 23);

        theirBirthday.setTime(date);

        ageDifference = dukesBirthday.get(Calendar.YEAR) - theirBirthday.get(Calendar.YEAR);
        logger.info("Raw ageDifference, is: " + ageDifference);

        if (dukesBirthday.before(theirBirthday) && (ageDifference > 0)) {
            ageDifference--;
        }
        FirstcupUser user = new FirstcupUser();
        user.setAgeDifference(ageDifference);
        user.setBirthday(theirBirthday);

        em.persist(user);
        return ageDifference;
    }
}
