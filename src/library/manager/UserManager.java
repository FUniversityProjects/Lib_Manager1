/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.manager;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class UserManager {

    private User user;
    private Password pass;
    private ArrayList<User> userName = new ArrayList<>();
    private ArrayList<Password> passList = new ArrayList<>();
    private HashMap<User, Password> accList = new HashMap<User, Password>();
    public int numberOfUser;

    public UserManager() {
        numberOfUser = 3;
    }

    Scanner scan = new Scanner(System.in);
    
    public void a() {
        for (Password element : passList) {
            System.out.println(element.getPassword() +": " +element.getID());
        }
    }

    public void writeFileUser() {
        File file = new File("./User.txt");
        FileOutputStream fileO = null;
        ObjectOutputStream objO = null;
        try {
            if (file.exists()) {
                fileO = new FileOutputStream(file);
                objO = new ObjectOutputStream(fileO);
                for (User element : userName) {
                    objO.writeObject(element);
                }
                objO.close();
                fileO.close();
                System.out.println("Đã Save dữ liệu xong");
            } else {
                file.createNewFile();
                fileO = new FileOutputStream(file);
                objO = new ObjectOutputStream(fileO);
                for (User element : userName) {
                    objO.writeObject(element);
                }
                objO.close();
                fileO.close();
                System.out.println("Đã Save dữ liệu xong");
            }
        } catch (IOException e) {

        }
        
    }
    public void writeFilePass() {
        File file = new File("./P.txt");
        FileOutputStream fileO = null;
        ObjectOutputStream objO = null;
        try {
            if (file.exists()) {
                fileO = new FileOutputStream(file);
                objO = new ObjectOutputStream(fileO);
                for (Password element : passList) {
                    objO.writeObject(element);
                }
                objO.close();
                fileO.close();
                System.out.println("Đã Save dữ liệu xong");
            } else {
                file.createNewFile();
                fileO = new FileOutputStream(file);
                objO = new ObjectOutputStream(fileO);
                for (Password element : passList) {
                    objO.writeObject(element);
                }
                objO.close();
                fileO.close();
                System.out.println("Đã Save dữ liệu xong");
            }
        } catch (IOException e) {

        }
    }

    public void readFileUser() {
        File file = new File("./User.txt");
        FileInputStream fileI = null;
        ObjectInputStream objI = null;
        try {
            if (file.exists()) {
                fileI = new FileInputStream(file);
                objI = new ObjectInputStream(fileI);
                while (fileI.available() > 0) {
                    User u = (User) objI.readObject();
                    userName.add(u);
                }
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
    public void readFilePass() {
        File file = new File("./P.txt");
        FileInputStream fileI = null;
        ObjectInputStream objI = null;
        try {
            if (file.exists()) {
                fileI = new FileInputStream(file);
                objI = new ObjectInputStream(fileI);
                while (fileI.available() > 0) {
                    Password p = (Password) objI.readObject();
                    passList.add(p);
                }
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
    
    public void readFile() {
        readFileUser();
        readFilePass();
    }
    
    public void writeFile() {
        writeFileUser();
        writeFilePass();
    }
    
    public void creatAcc() {
        user = new User();
        pass = new Password();
        user.input();
        user.setID(autoID());
        pass.setID(user.getID());
        pass.input();
        accList.put(user, pass);
        userName.add(user);
        passList.add(pass);
    }
    
    public void connect() {
        for (User elementUser : userName) {
            for (Password elementPassword : passList) {
                if(elementUser.getID() == elementPassword.getID()) {
                    accList.put(elementUser, elementPassword);
                }
            }
        }
    }
    
    public boolean checkExistUser(String userName) {
        int flag = 0;
        for (User element : this.userName) {
            if (element.getUserName().equals(userName)) {
                flag = 1;
            }
        }
        
        return (flag == 1? true : false);
    }

    public void display() {
        System.out.println("----------- THÔNG TIN CỦA KHÁCH HÀNG -----------");
        for (User element : userName) {
            element.display();
        }
    }

    /**
     * Tự cấp ID cho user mới
     * @return ID (String)
     */
    public String autoID() {
        Calendar currentCalendar = Calendar.getInstance();
        int year = currentCalendar.get(Calendar.YEAR);
        int count = 1;
        if (userName.size() > 0) {
            String[] id = userName.get(userName.size()-1).getID().split("");
            String a = id[id.length-4]+id[id.length-3]+id[id.length-2]+id[id.length-1];
            count = Integer.parseInt(a)+1;
        }
        DecimalFormat formID = new DecimalFormat("0000");
        String autoID = formID.format(count);

        return "U" + year + autoID;
    }
    
    public void findUser() {
        ArrayList<User> selectUser = new ArrayList<User>();
        System.out.print("Nhap tu khoa: ");
        String key = scan.nextLine();
        int flag = 0;
        System.out.println("Kết quả tìm kiếm:");
        for (User element : userName) {
            if (element.getID().contains(key)){
                element.display();
                selectUser.add(element);
                flag = 1;
            }
            else if (element.getUserName().contains(key)){
                element.display();
                selectUser.add(element);
                flag = 1;
            }
            else if (element.getCMND().contains(key)){
                element.display();
                flag = 1;
                selectUser.add(element);
            }
            else if (element.getPhone().contains(key)){
                element.display();
                selectUser.add(element);
                flag = 1;
            }
            else if (element.getUserName().contains(key)){
                element.display();
                selectUser.add(element);
                flag = 1;
            }
            else if (element.getName().contains(key)){
                element.display();
                selectUser.add(element);
                flag = 1;
            }
            
        }
        int c = 0;
        if (flag == 0)
                System.out.println("Không tìm thấy!");
        else {
            System.out.println("1. Xóa tất cả người dùng này."
                    + "\n2. Sửa thông tin người dùng này."
                    + "\n3. Hủy bỏ.");
            c = scan.nextInt();
            scan.nextLine();
            if(c == 1) {
                userName.removeAll(selectUser);
                for (User element : selectUser) {
                    for (int i = 0; i < passList.size(); i++) {
                        if(passList.get(i).getID().equals(element.getID())) {
                            passList.remove(passList.get(i));
                        }
                    }
                }
            }
            else if (c == 2) {
                if(selectUser.size() > 1) {
                    System.out.println("Không thể sửa thông tin của nhiều người dùng một lúc!");
                }
                else if (selectUser.size() == 1) {
                    User u = new User();
                    u.setID(selectUser.get(0).getID());
                    u.setUserName(selectUser.get(0).getUserName());
                    u.inputEdit();
                    userName.removeAll(selectUser);
                    userName.add(u);
                    
                }
            }
        }
    }
    
    public void deleteUser() {
        
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
            choice = scan.nextInt();
            scan.nextLine();
            switch (choice) {
                case 1:
                    do {
                        choice = 0;
                        System.out.println("----------- QUẢN LÍ SÁCH -----------");
                        System.out.println("1. Tìm/xem sách theo tên.\n"
                                + "2. Tìm/xem sách theo tác giả.\n"
                                + "3. Tìm/xem sách theo thể loại.\n"
                                + "4. Trở lại.");
                        System.out.print("\tLựa chọn của bạn: ");
                        choice2 = scan.nextInt();
                        scan.nextLine();
                        switch (choice2) {
                            case 1:
                            case 2:
                            case 3:
                            default:
                                menuClient();
                        }
                    } while (choice2 > 0 && choice2 < 3);
                    break;
                case 2:
                    do {
                        System.out.println("----------- THÔNG TIN CÁ NHÂN -----------");
                        System.out.println("1. Xem sách đang mượn.\n"
                                + "2. Xem thông tin cá nhân.\n"
                                + "3. Thay đổi password.\n"
                                + "4. Trở lại.");
                        System.out.print("\tLựa chọn của bạn: ");
                        choice2 = scan.nextInt();
                        scan.nextLine();
                        switch (choice2) {
                            case 1:
                            case 2:
                            case 3:
                            default:
                                menuClient();
                        }
                    } while (choice2 > 0 && choice2 < 3);
                    break;
                default:
                    break;
            }
        } while (choice > 0 && choice < 2);
    }
}
