/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.manager;
import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author ACER
 */
public class UserManager {
    private User user;
    private Password pass;
    private HashMap<User, Password> accList= new HashMap<User, Password>();
    public int numberOfUser;

    public UserManager() {
        numberOfUser = 3;
    }
    

    Scanner sc = new Scanner(System.in);
    
    public void writeFileUser() {
        File file = new File("./User.txt");
        FileOutputStream fileO = null;
        ObjectOutputStream objO = null;
        try {
            if (file.exists()) {
                fileO = new FileOutputStream(file);
                objO = new ObjectOutputStream(fileO);
                objO.writeObject(this);
                objO.close();
                fileO.close();
                System.out.println("Đã Save dữ liệu xong");
            } else {
                file.createNewFile();
                fileO = new FileOutputStream(file);
                objO = new ObjectOutputStream(fileO);
                objO.writeObject(this);
                objO.close();
                fileO.close();
            }
        } catch (IOException e) {

        }
    }
    
    public void readFile() {
        File file = new File("./User.txt");
        FileInputStream fileI = null;
        ObjectInputStream objI = null;
        
        try {
            if (file.exists()) {
                fileI = new FileInputStream(file);
                objI = new ObjectInputStream(fileI);
                UserManager a = (UserManager) objI.readObject();
                objI.close();
                fileI.close();
                System.out.println("Đã load dữ liệu xong");
            } else {
                file.createNewFile();
                System.out.println("Da tao file moi");
            }
        } catch (IOException e) {
            System.out.println("Dữ liệu trống");
        } catch (ClassNotFoundException e) {

        }
    }

    
    public void creatAcc() {
        user = new User();
        pass = new Password();
        user.input();
        pass.input();
        accList.put(user, pass);
    }
    
    public void display() {
        Set<User> userSet = accList.keySet();
        for (User element : userSet) {
            element.display();
        }
    }
    
    //menu client
    public void menuClient() {
        int choice = 0;
        int choice2 = 0;
        do {
            System.out.println("----------- MENU KHÁCH HÀNG -----------");
            System.out.println("1. Quản lí sách.\n"
                    + "2. Thông tin cá nhân.\n"
                    + "3. Thoát.");
            System.out.print("\tLựa chọn của bạn: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    do{
                        choice = 0;
                        System.out.println("----------- QUẢN LÍ SÁCH -----------");
                        System.out.println("1. Tìm/xem sách theo tên.\n"
                                + "2. Tìm/xem sách theo tác giả.\n"
                                + "3. Tìm/xem sách theo thể loại.\n"
                                + "4. Trở lại.");
                        System.out.print("\tLựa chọn của bạn: ");
                        choice2 = sc.nextInt(); sc.nextLine();
                        switch(choice2){
                            case 1:
                            case 2:
                            case 3:
                            default: menuClient();
                        }
                    }while(choice2 > 0 && choice2 < 3);
                    break;
                case 2:
                    do{
                        System.out.println("----------- THÔNG TIN CÁ NHÂN -----------");
                        System.out.println("1. Xem sách đang mượn.\n"
                                + "2. Xem thông tin cá nhân.\n"
                                + "3. Thay đổi password.\n"
                                + "4. Trở lại.");
                        System.out.print("\tLựa chọn của bạn: ");
                        choice2 = sc.nextInt(); sc.nextLine();
                        switch(choice2){
                            case 1:
                            case 2:
                            case 3:
                            default: menuClient();
                        }
                    }while(choice2 > 0 && choice2 < 3);
                    break;
                default: break;
            }
        }while(choice > 0 && choice < 2);
    
    }
    
    
}
