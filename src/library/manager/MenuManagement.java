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
public class MenuManagement {

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

    public void menuLogin() {
        UserManager a = new UserManager();
        int flag = 0;
        a.readFile();
        a.connect();

        System.out.println("----------- LOGIN -----------");
        System.out.print("TÀI KHOẢN: ");
        tk = scan.nextLine();
        System.out.print("MẬT KHẨU: ");
        mk = scan.nextLine();
        for (User element : a.getUserName()) {
            if (tk.equals(element.getUserName())) {
                for (Password password : a.getPassList()) {
                    if (element.getID().equals(password.getID())) {
                        if (password.getPassword().equals(mk) && element.getIsAd() == false) {
                            menuClient();
                            flag = 1;
                        } else if (password.getPassword().equals(mk) && element.getIsAd() == true) {
                            menuAdmin();
                            flag = 1;
                        }
                    }
                }
            }
        }
        if (flag == 0) {
            System.out.println("Sai tài khoản hoặc mật khẩu!");
        }

    }

    //menu client
    public void menuClient() {
        BookManager b = new BookManager();
        b.readFile();
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
