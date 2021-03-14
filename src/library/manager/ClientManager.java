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
 * @author ACER
 */
public class ClientManager {

    ArrayList<Client> clientList = new ArrayList<>();
    public int numberOfclient;

    public void addFixdelete() {

    }

    public void findByname() {

    }

    public void findByID() {

    }

    Scanner sc = new Scanner(System.in);
    //menu client
    public void menuClient() {
        int choice = 0;
        int choice2 = 0;
        do {
            System.out.println("----------- CLIENT MENU -----------");
            System.out.println("1. Quản lí sách.\n"
                    + "2. Thông tin cá nhân.\n"
                    + "3. Thoát.");
            System.out.print("\tYour choice: ");
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
                        System.out.print("\tYour choice: ");
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
                        System.out.print("\tYour choice: ");
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
