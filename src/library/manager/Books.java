/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.manager;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class Books extends Book{
    public int numberOfBooks;
    public ArrayList<Book> books;

    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    public void setNumberOfBooks(int numberOfBooks) {
        this.numberOfBooks = numberOfBooks;
    }
    Scanner scan = new Scanner(System.in);
    
    public void inputs() {
        super.input();
        System.out.print("- Số lượng: "); 
        this.setNumberOfBooks(scan.nextInt());
        scan.nextLine();
        books = new ArrayList<Book>();
        for (int i = 0; i < this.getNumberOfBooks(); i++) {
            Book b = new Book();
            b.setID("BO"+this.getAmount()+(int)getMoney()+(int)Math.floor(Math.random()*10)+(int)Math.floor(Math.random()*10)+(int)Math.floor(Math.random()*10)+(int)Math.floor(Math.random()*10)+(int)Math.floor(Math.random()*10)+(int)Math.floor(Math.random()*10)+(int)Math.floor(Math.random()*10)+(int)Math.floor(Math.random()*10)+(int)Math.floor(Math.random()*10)+(int)Math.floor(Math.random()*10));
            b.setBookname(this.getBookname());
            b.setAuthor(this.getAuthor());
            b.setCondition(this.getCondition());
            b.setKind(this.getKind());
            b.setMoney(this.getMoney());
            b.setAmount(this.getNumberOfBooks());
            books.add(b);
        }
        
        
    }
}
