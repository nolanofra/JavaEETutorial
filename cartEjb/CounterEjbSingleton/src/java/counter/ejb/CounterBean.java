/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package counter.ejb;

import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author nolanof
 */
@Startup
@Singleton
public class CounterBean {

    private int hits = 1;

    // Increment and return the number of hits
    public int getHits() {
        return hits++;
    }
}
