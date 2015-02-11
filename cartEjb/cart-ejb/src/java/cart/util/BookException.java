/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart.util;

/**
 *
 * @author nolanof
 */
public class BookException extends Exception {
    private static final long serialVersionUID = 6274585742564840905L;
    public BookException() {
    }

    public BookException(String msg) {
        super(msg);
    }
}

