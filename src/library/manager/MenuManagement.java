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
    UserManager a;
    String tk;
    String mk;

    public MenuManagement() throws IOException {
        a = new UserManager();
    }

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

    public void loginMenu() throws IOException, FileNotFoundException, ClassNotFoundException, MyException {
        int i = a.login();
        if (i == 1) {
            b.readFile();
            menuClient();
        } else if (i == 2) {
            a.readFile();
            b.readFile();
            menuAdmin();
        }
    }

    //menu client
    public void menuClient() throws MyException {
        int choice = 0;
        int choice2 = 0;
        do {
            System.out.println("----------- MENU KHÁCH HÀNG -----------");
            System.out.print("1. Quản lí sách.\n"
                    + "2. Thông tin cá nhân.\n"
                    + "3. Thoát."
                    + "\n\tLựa chọn của bạn: ");
            choice = scan.nextInt();
            scan.nextLine();
            switch (choice) {
                case 1:
                    do {
                        System.out.println("----------- QUẢN LÍ SÁCH -----------");
                        System.out.print("1. Xem tất cả sách.\n"
                                + "2. Tìm/xem sách.\n"
                                + "3. Trở lại."
                                + "\n\tLựa chọn của bạn: ");
                        choice2 = scan.nextInt();
                        scan.nextLine();
                        switch (choice2) {
                            case 1:
                                b.display();
                                break;
                            case 2:
                                b.findBook();
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("Xin lỗi! Lựa chọn không hợp lệ!");
                                break;
                        }
                    } while (choice2 > 0 && choice2 < 3);
                    break;
                case 2:
                    do {
                        System.out.println("----------- THÔNG TIN CÁ NHÂN -----------");
                        System.out.print("1. Xem sách đang mượn.\n"
                                + "2. Xem thông tin cá nhân.\n"
                                + "3. Thay đổi mật khẩu.\n"
                                + "4. Trở lại."
                                + "\n\tLựa chọn của bạn: ");
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
                            case 4:
                                break;
                            default:
                                System.out.println("Xin lỗi! Lựa chọn không hợp lệ!");
                                break;
                        }
                    } while (choice2 > 0 && choice2 < 4);
                    break;
                case 3:
                    System.out.println("Cảm ơn đã sử dụng dịch vụ!");
                    break;
                default:
                    System.out.println("Xin lỗi! Chỉ chọn từ 1 đến 3!");
                    menuClient();
            }
        } while (choice > 0 && choice < 3);
    }

    //menu admin
    public void menuAdmin() throws IOException, FileNotFoundException, ClassNotFoundException, MyException {

        int choice = 0;
        int choice2 = 0;
        do {
            System.out.println("----------- ADMIN MENU -----------");
            System.out.print("1. Quản lí sách.\n"
                    + "2. Quản lí khách hàng.\n"
                    + "3. Báo cáo."
                    + "\n4. Đổi mật khẩu."
                    + "\n5. Thoát."
                    + "\n\tLựa chọn của bạn: ");
            choice = scan.nextInt();
            scan.nextLine();
            switch (choice) {
                case 1:
                    do {
                        System.out.println("----------- QUẢN LÍ SÁCH -----------");
                        System.out.print("1. Thêm sách\n"
                                + "2. Sửa sách.\n"
                                + "3. Xoá sách.\n"
                                + "4. Tìm sách.\n"
                                + "5. Xem tất cả sách."
                                + "\n6. Mượn sách."
                                + "\n7. Trả sách."
                                + "\n8. Trở lại."
                                + "\n\tLựa chọn của bạn: ");
                        choice2 = scan.nextInt();
                        scan.nextLine();
                        switch (choice2) {
                            case 1:
                                b.addBooks();
                                break;
                            case 2:
                                b.editByID();
                                break;
                            case 3:
                                b.deleteByID();
                                break;
                            case 4:
                                b.findBook();
                                break;
                            case 5:
                                b.display();
                                break;
                            case 6:
                                a.borrowBook();
                                break;
                            case 7:
                                a.reFund();
                                break;
                            case 8:
                                break;
                            default:
                                System.out.println("Xin lỗi! Lựa chọn không hợp lệ!");
                                break;
                        }
                    } while (choice2 > 0 && choice2 < 8);
                    break;
                case 2:
                    do {
                        System.out.println("----------- QUẢN LÍ KHÁCH HÀNG -----------");
                        System.out.print("1. Thêm khách hàng mới.\n"
                                + "2. Danh sách khách hàng.\n"
                                + "3. Quản lý khách hàng.\n"
                                + "4. Trở lại."
                                + "\n\tLựa chọn của bạn: ");
                        choice2 = scan.nextInt();
                        scan.nextLine();
                        switch (choice2) {
                            case 1:
                                a.creatAcc();
                                break;
                            case 2:
                                a.displayList();
                                break;
                            case 3:
                                a.findUser();
                                break;
                            case 4:
                                break;
                            default:
                                System.out.println("Xin lỗi! Lựa chọn không hợp lệ!");
                                break;
                        }
                    } while (choice2 > 0 && choice2 < 4);
                    break;
                case 3:
                    do {
                        System.out.println("----------- BÁO CÁO -----------");
                        System.out.print("1. Số lượng user hiện có.\n"
                                + "2. Số lượng sách hiện có.\n"
                                + "3. Danh sách user cháy deadline.\n"
                                + "4. Trở lại."
                                + "\n\tLựa chọn của bạn: ");
                        choice2 = scan.nextInt();
                        scan.nextLine();
                        switch (choice2) {
                            case 1:
                                a.reportUser();
                                break;
                            case 2:
                                a.reportBook();
                                break;
                            case 3:
                                a.reportUserOverDeadline();
                                break;
                            case 4:
                                break;
                            default:
                                System.out.println("Xin lỗi! Lựa chọn không hợp lệ!");
                                break;
                        }
                    } while (choice2 > 0 && choice2 < 4);
                    break;
                case 4:
                    a.changePass();
                    break;
                case 5:
                    System.out.println("Cảm ơn bạn đã sử dụng dịch vụ!");
                    break;
                default:
                    System.out.println("Xin lỗi! Chỉ chọn từ 1 đến 5!");
                    menuAdmin();
            }
        } while (choice > 0 && choice < 5);
    }
}
