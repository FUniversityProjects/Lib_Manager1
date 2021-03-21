/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.manager;
import java.io.Serializable;

/**
 *
 * @author ACER
 */
class Admin extends User implements Serializable {
    private String ID;
    private String acc;
    private String pass;

    public Admin() {
        
    }

    public Admin(String ID, String acc, String pass) {
        this.ID = ID;
        this.acc = acc;
        this.pass = pass;
    }

    public String getAcc() {
        return acc;
    }
    
    public void setAcc(String acc) {
        this.acc = acc;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    //check Account
    String patternAccount = "^[a-zA-Z]\\w*$";
    public void checkAccount(){
        if(this.getAcc().matches(patternAccount)){
            System.out.print("- Nhập mật khẩu: "); this.setPass(sc.nextLine());
        } else {
            System.out.println("-Tài khoản sai cú pháp! Vui lòng nhập lại!!!-");
            System.out.print("- Nhập tài khoản: "); this.setAcc(sc.nextLine());
            checkAccount();
        }
    }
    
    @Override
    public void input(){
        System.out.println("----------- NHẬP THÔNG TIN CỦA QUẢN TRỊ VIÊN -----------");
        super.input();
        System.out.print("- Nhập ID: "); this.setID(sc.nextLine());
        System.out.print("- Nhập tài khoản: "); this.setAcc(sc.nextLine());
        checkAccount();
    }
    

    public void displayA(){
        System.out.println("----------- THÔNG TIN QUẢN TRỊ VIÊN -----------");
        super.display();
        System.out.println("- ID quản trị viên là " + this.getID());
        System.out.println("- Tài khoản quản trị viên là " + this.getAcc());
        System.out.println("- Mật khẩu quản trị viên là " + this.getPass());
    }
}