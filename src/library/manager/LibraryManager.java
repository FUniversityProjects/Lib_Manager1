
package library.manager;
import java.io.IOException;

/**
 *
 * @author ACER
 */
public class LibraryManager {

    public static void main(String[] args) {

        try {
            MenuManagement m = new MenuManagement();
            m.loginMenu();
            
        } catch (IOException | ClassNotFoundException | MyException ex) {
            System.out.println(ex.getCause() + ex.getMessage());
        }

    }
}
