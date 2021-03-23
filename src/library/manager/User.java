/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.manager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER
 */
class User extends Person implements Serializable{
    private String ID;
    private String hobby;
    private boolean VIP;
    private boolean borrow;
    private String userName;
    ArrayList<Book> borrowedBooks = new ArrayList<Book>();

    public User(String ID, String hobby, boolean VIP, boolean borrow) {
        this.ID = ID;
        this.hobby = hobby;
        this.VIP = VIP;
        this.borrow = borrow;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) throws MyException {
        if(userName.equals("")) {
            throw new MyException("Tên tài khoản không thể trống!");
        }
        else {
            this.userName = userName;
        }
    }

    public User() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public boolean getVIP() {
        return VIP;
    }

    public void setVIP(boolean VIP) {
        this.VIP = VIP;
    }

    public boolean getBorrow() {
        return borrow;
    }

    public void setBorrow(boolean borrow) {
        this.borrow = borrow;
    }
    
    @Override
    public void input(){
        try {
            System.out.println("----------- NHẬP THÔNG TIN NGƯỜI DÙNG -----------");
            System.out.print("- Nhập tài khoản: "); this.setUserName(sc.nextLine());
            super.input();
        } catch (MyException ex) {
            System.out.println(ex.getMessage());
            input();
        }
    }
    
    public void inputEdit(){
        System.out.println("----------- NHẬP THÔNG TIN NGƯỜI DÙNG -----------");
        super.input();
    }
    
    public void displayList(){
        System.out.print("ID: "+this.getID()+"   ");
        super.displayF();
        System.out.println("Đang mượn: "+this.getBorrow());
    }
    
    @Override
    public void display() {
        System.out.println("- ID: "+this.getID());
        super.display();
        System.out.println("- Đang mượn: "+this.getBorrow());
    }
}

