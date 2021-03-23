/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.manager;
import java.io.Serializable;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class Password implements Serializable{
    private String password;
    private String ID;
    private Date dateUpdataPass;
    
    public Password() {
    }
    
    transient Scanner scan = new Scanner(System.in);
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws MyException {
        if(password.equals("")) {
            throw new MyException("Mật khẩu không thể bỏ trống!");
        }
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    
    public void input() {
        try {
            System.out.print("- Nhập mật khẩu: ");
            this.setPassword(scan.nextLine());
        } catch (MyException ex) {
            System.out.println(ex.getMessage());
            input();
        }
    }
    
}
