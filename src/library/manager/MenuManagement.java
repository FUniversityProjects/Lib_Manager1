/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.manager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class MenuManagement {
    BookManager b = new BookManager();
    UserManager a = new UserManager();
    String tk;
    String mk;

    public String getTk() {
        return tk;
    }

    public void setTk(String tk) {
        this.tk = tk;
    }

    public String getMk() {
        return mk;
    }

    public void setMk(String mk) {
        this.mk = mk;
    }

    Scanner scan = new Scanner(System.in);

    public void loginMenu() throws IOException, FileNotFoundException, ClassNotFoundException {

        if (a.login()) {
            b.readFile();
            menuClient();
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
                                b.findByName();
                                break;
                            case 2:
                                b.findByAuthor();
                                break;
                            case 3:
                                b.findByKind();
                                break;
                            default:
                                menuClient();
                        }
                    } while (choice2 > 0 && choice2 < 4);
                    break;
                case 2:
                    do {
                        System.out.println("----------- THÔNG TIN CÁ NHÂN -----------");
                        System.out.println("1. Xem sách đang mượn.\n"
                                + "2. Xem thông tin cá nhân.\n"
                                + "3. Thay đổi mật khẩu.\n"
                                + "4. Trở lại.");
                        System.out.print("\tLựa chọn của bạn: ");
                        choice2 = scan.nextInt();
                        scan.nextLine();
                        switch (choice2) {
                            case 1:
                                a.borrowedBookList();
                                break;
                            case 2:
                                a.display();
                                break;
                            case 3:
                                a.changePass();
                                break;
                            default:
                                menuClient();
                        }
                    } while (choice2 > 0 && choice2 < 4);
                    break;
                default:
                    break;
            }
        } while (choice > 0 && choice < 2);
    }

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
            System.out.print("\tLựa chọn của bạn: ");
            choice = scan.nextInt();
            scan.nextLine();
            switch (choice) {
                case 1:
                    do {
                        System.out.println("----------- QUẢN LÍ SÁCH -----------");
                        System.out.println("1. Thêm sách\n"
                                + "2. Sửa sách.\n"
                                + "3. Xoá sách.\n"
                                + "4. Tìm sách.\n"
                                + "5. Trở lại.");
                        System.out.print("\tLựa chọn của bạn: ");
                        choice2 = scan.nextInt();
                        scan.nextLine();
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
                        System.out.print("\tLựa chọn của bạn: ");
                        choice2 = scan.nextInt();
                        scan.nextLine();
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
                        System.out.print("\tLựa chọn của bạn: ");
                        choice2 = scan.nextInt();
                        scan.nextLine();
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
