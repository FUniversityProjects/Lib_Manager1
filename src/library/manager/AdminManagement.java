/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.manager;

import java.util.Scanner;

/**
 *
 * @author PC
 */
public class AdminManagement {

    Scanner sc = new Scanner(System.in);

    //menu admin
    public void menuAdmin() {
        int choice = 0;
        int choice2 = 0;
        do {
            System.out.println("----------- ADMIN MENU -----------");
            System.out.println("1. Quản lí sách.\n"
                    + "2. Quản lí khách hàng.\n"
                    + "3. Báo cáo.\n"
                    + "4. Thoát.");
            System.out.print("\tYour choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    do {
                        System.out.println("----------- QUẢN LÍ SÁCH -----------");
                        System.out.println("1. Thêm sách\n"
                                + "2. Sửa sách.\n"
                                + "3. Xoá sách.\n"
                                + "4. Tìm sách.\n"
                                + "5. Trở lại.");
                        System.out.print("\tYour choice: ");
                        choice2 = sc.nextInt();
                        sc.nextLine();
                        switch (choice2) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            default:
                                menuAdmin();
                        }
                    } while (choice2 > 0 && choice2 < 5);
                    break;
                case 2:
                    do {
                        System.out.println("----------- QUẢN LÍ KHÁCH HÀNG -----------");
                        System.out.println("1. Thêm thông tin khách hàng.\n"
                                + "2. Sửa thông tin khách hàng.\n"
                                + "3. Xoá thông tin khách hàng.\n"
                                + "4. Tìm khách hàng.\n"
                                + "5. Trở lại.");
                        System.out.print("\tYour choice: ");
                        choice2 = sc.nextInt();
                        sc.nextLine();
                        switch (choice2) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            default:
                                menuAdmin();
                        }
                    } while (choice2 > 0 && choice2 < 5);
                    break;
                case 3:
                    do {
                        System.out.println("----------- BÁO CÁO -----------");
                        System.out.println("1. Số sách được mượn (Tháng).\n"
                                + "2. chưa có idea.\n"
                                + "3. chưa có idea.\n"
                                + "4. chưa có idea.\n"
                                + "5. Trở lại.");
                        System.out.print("\tYour choice: ");
                        choice2 = sc.nextInt();
                        sc.nextLine();
                        switch (choice2) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            default:
                                menuAdmin();
                        }
                    } while (choice2 > 0 && choice2 < 5);
                    break;
                default:
                    System.out.println("Bye!");
                    break;
            }
        } while (choice > 1 && choice < 4);
    }
}
