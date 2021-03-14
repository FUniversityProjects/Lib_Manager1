/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.manager;

/**
 *
 * @author ACER
 */
class Client extends Person{
    private String ID;
    private String hobby;
    private boolean VIP;
    private boolean borrow;

    public Client(String ID, String hobby, boolean VIP, boolean borrow) {
        this.ID = ID;
        this.hobby = hobby;
        this.VIP = VIP;
        this.borrow = borrow;
    }

    public Client() {
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
        System.out.println("----------- NHẬP THÔNG TIN KHÁCH HÀNG -----------");
        super.input();
        System.out.print("- Nhập ID: "); this.setID(sc.nextLine());
    }
    
    @Override
    public void display(){
        System.out.println("----------- THÔNG TIN CỦA KHÁCH HÀNG -----------");
        super.display();
        System.out.println("ID khách hàng là " + this.getID());
    }
    
}

