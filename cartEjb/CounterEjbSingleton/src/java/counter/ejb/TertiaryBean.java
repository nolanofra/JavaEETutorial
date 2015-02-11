/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package counter.ejb;

import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.DependsOn;
import javax.ejb.Singleton;

/**
 *
 * @author nolanof
 */
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
@Singleton
@DependsOn({"CounterBean", "SecondaryBean"})
public class TertiaryBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
