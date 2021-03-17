/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.manager;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class Password {
    private String password;
    private String ID;
    private Date dateUpdataPass;
    
    public Password() {
    }
    
    Scanner scan = new Scanner(System.in);
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    
    public void input() {
        System.out.print("- Nhập mật khẩu: ");
        this.setPassword(scan.nextLine());
    }
    
}
