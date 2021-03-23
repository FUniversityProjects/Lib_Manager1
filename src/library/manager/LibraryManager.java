/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
                } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
    }
}