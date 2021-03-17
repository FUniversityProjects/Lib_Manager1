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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        UserManager um = new UserManager();
        um.creatAcc();
        um.display();
    }
}
