/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart.app.client;

import cart.ejb.common.Cart;
import cart.util.BookException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author nolanof
 */
public class CartClient {
           
    Cart cart;

    public CartClient(String[] args) {        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CartClient client = new CartClient(args);
        client.doTest();
    }

    public void doTest() {
        try {
            try {
                this.cart = (Cart)
                        new InitialContext().lookup("java:global/cart-ejb/CartBean");
            } catch (NamingException ex) {
                Logger.getLogger(CartClient.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            cart.initialize("Duke d'Url", "123");
            cart.addBook("Infinite Jest");
            cart.addBook("Bel Canto");
            cart.addBook("Kafka on the Shore");

            List<String> bookList = cart.getContents();

            Iterator<String> iterator = bookList.iterator();

            while (iterator.hasNext()) {
                String title = iterator.next();
                System.out.println("Retrieving book title from cart: " + title);
            }

            System.out.println("Removing \"Gravity's Rainbow\" from cart.");
            cart.removeBook("Gravity's Rainbow");
            cart.remove();

            System.exit(0);
        } catch (BookException ex) {
            System.err.println("Caught a BookException: " + ex.getMessage());
            System.exit(0);
        }
    }
}
