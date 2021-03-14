/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.manager;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class LibraryManager {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        BookManager a = new BookManager();
        a.addBooks();
        a.display();
        a.editByID();
        a.display();
    }
}
