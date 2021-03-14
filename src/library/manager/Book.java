/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.manager;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class Book implements Serializable{

    public double money;
    public String bookname;
    public String author;
    public String kind;
    public boolean borrowed;
    public String condition;
    public int amount;
    public String ID;

    public Book() {
        this.borrowed = false;
    }

    public Book(double money, String bookname, String Author, String kind, boolean borrowed, String condition) {
        this.money = money;
        this.bookname = bookname;
        this.author = Author;
        this.kind = kind;
        this.borrowed = borrowed;
        this.condition = condition;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String Author) {
        this.author = Author;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public boolean getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    transient Scanner sc = new Scanner(System.in);

    public void input() {
        System.out.println("----------- NHẬP THÔNG TIN SÁCH -----------");
        System.out.print("- Tên: ");
        this.setBookname(sc.nextLine());
        System.out.print("- Tác giả: ");
        this.setAuthor(sc.nextLine());
        System.out.print("- Thể loại: ");
        this.setKind(sc.nextLine());
        System.out.print("- Tình trạng: ");
        this.setCondition(sc.nextLine());
        System.out.print("- Giá tiền (nghìn VNĐ): ");
        this.setMoney(sc.nextDouble());
        sc.nextLine();
    }

    public void display() {
        System.out.println("----------- THÔNG TIN SÁCH -----------");
        System.out.println("- Mã sách: " + this.getID());
        System.out.println("- Tên sách: " + this.getBookname());
        System.out.println("- Tác giả: " + this.getAuthor());
        System.out.println("- Thể loại sách: " + this.getKind());
        System.out.println("- Tình trạng sách: " + this.getCondition());
        System.out.println("- Giá sách (nghìn VNĐ): " + this.getMoney());
        System.out.println("- Đang mượn: " + this.getBorrowed());
    }

    public void displayF() {
        System.out.format("ID: %s   Tên: %s   Thể loại: %s   Tác giả: %s   Số lượng: %d   Đang mượn: %s %n", this.getID(), this.getBookname(), this.getKind(), this.getAuthor(), this.getAmount(), this.getBorrowed());
    }
}
