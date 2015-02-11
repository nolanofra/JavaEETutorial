/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter.ejb;

import java.math.BigDecimal;
import javax.ejb.Stateless;

/**
 *
 * @author nolanof
 */
@Stateless
public class ConverterBean {

    private BigDecimal euroRate = new BigDecimal("0.883500");
   

    public BigDecimal dollarToEur(BigDecimal dollar) {
        BigDecimal result = dollar.multiply(euroRate);
        return result.setScale(2, BigDecimal.ROUND_UP);
    }
}
