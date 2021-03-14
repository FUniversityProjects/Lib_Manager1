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
        Book b = new Book();
        
        b.input();
        File file = new File("C:\\Users\\DELL\\Desktop\\test.txt");
        OutputStream ip = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(ip);
        oos.writeObject(b);
        oos.close();
        ip.close();
        InputStream aa = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(aa);
        Book book = new Book();
        System.out.println(book.getBookname());
        book = (Book) ois.readObject();
        System.out.println(book.getBookname());//////
    }
    
}
