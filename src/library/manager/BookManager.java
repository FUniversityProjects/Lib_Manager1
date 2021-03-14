/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.manager;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class BookManager {

    public ArrayList<Book> bookList = new ArrayList<>();
    public int numberOfBooks;
    public Books books = new Books();

    public void addBooks() {
        int flag = 0;
        books.inputs();
        for (Book element : bookList) {
            if (element.getBookname().equals(books.books.get(0).getBookname())) {
                flag = 1;
            }
        }
        if (flag == 0) {
            bookList.addAll(books.books);
        } else {
            bookList.addAll(books.books);
            for (int i = 0; i < bookList.size(); i++) {
                if (bookList.get(i).getBookname().equals(books.books.get(0).getBookname())) {
                    bookList.get(i).setAmount(bookList.get(i).getAmount() + books.getNumberOfBooks());
                }
            }
            for(Book element : bookList) {
                if(element.getBookname().equals(books.books.get(0).getBookname())) {
                    for (int i = 0; i < books.books.size(); i++) {
                        books.books.get(i).setAmount(element.getAmount());
                    }
                    break;
                }
            }
        }

    }

    public void display() {
        for (Book element : bookList) {
            element.displayF();
        }
    }
    
    public void readFile() throws IOException, ClassNotFoundException {
        File file = new File("./Books.txt");
        
        if(file.exists()) {
            FileInputStream fileI = new FileInputStream(file);
            ObjectInputStream objI = new ObjectInputStream(fileI);
            while (fileI.available() > 0) {
                Book book = (Book) objI.readObject();
                bookList.add(book);
                
            }
            System.out.println("Đã load dữ liệu xong");
        }
        else {
            file.createNewFile();
        }
        
    }
    
    public void writeFile() throws FileNotFoundException, IOException {
        File file = new File("./Books.txt");
        if(file.exists()) {
            FileOutputStream fileO = new FileOutputStream(file);
            ObjectOutputStream objO = new ObjectOutputStream(fileO);
            for (Book element : bookList) {
                objO.writeObject(element);
            }
            System.out.println("Đã Save dữ liệu xong");
        }
        else {
            file.createNewFile();
        }
    }
        
    public void findByname() {

    }

    public void findBykind() {

    }

    public void findByauthor() {

    }

    public void findByID() {

    }
}
