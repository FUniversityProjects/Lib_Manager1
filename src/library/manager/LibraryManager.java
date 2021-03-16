/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;

/**
 *
 * @author ACER
 */
public class LibraryManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        File file = new File("./User.txt");
        FileInputStream fileI = null;
        ObjectInputStream objI = null;

        if (file.exists()) {
            fileI = new FileInputStream(file);
            objI = new ObjectInputStream(fileI);
            UserManager a = (UserManager) objI.readObject();
            objI.close();
            fileI.close();
            System.out.println(a.numberOfUser);
        }
    }
}
