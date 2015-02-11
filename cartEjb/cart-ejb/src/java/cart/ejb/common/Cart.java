/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart.ejb.common;

import cart.util.BookException;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author nolanof
 */
@Remote
public interface Cart {
    public void initialize(String person) throws BookException;

    public void initialize(
        String person,
        String id) throws BookException;

    public void addBook(String title);

    public void removeBook(String title) throws BookException;

    public List<String> getContents();

    public void remove();
}

