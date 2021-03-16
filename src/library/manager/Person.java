/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.manager;

import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class Person {

    private int age;
    private String name;
    private String phone;
    private String CMND;
    private String CCCD;
    private String mail;
    private String Address;
    private boolean isAd;
    Scanner sc = new Scanner(System.in);

    public Person() {
    }

    public Person(double money, int age, String phone, String CMND, String mail, String Address, String CCCD) {
        this.age = age;
        this.phone = phone;
        this.CMND = CMND;
        this.mail = mail;
        this.Address = Address;
        this.CCCD = CCCD;
    }

    public boolean getIsAd() {
        return isAd;
    }

    public void setIsAd(boolean isAd) {
        this.isAd = isAd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    //check email
    String patternEmail = "^[a-zA-Z]\\w*@[a-zA-Z]\\w*(\\.[a-zA-Z]\\w*)+$";

    public void checkMail() {
        if (this.getMail().matches(patternEmail)) {
            System.out.println();
        } else {
            System.out.println("Email không hợp lệ! Vui lòng nhập lại!!!");
            System.out.print("- Nhập email: ");
            this.setMail(sc.nextLine());
            checkMail();
        }
    }

    //check số điện thoại
    String patternPhone = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";

    public void checkPhone() {
        if (this.getPhone().matches(patternPhone)) {
            System.out.print("- Nhập CMND: ");
            this.setCMND(sc.nextLine());
            checkCMND();
        } else {
            System.out.println("Số điện thoại không hợp lệ!! Vui lòng nhập lại!!");
            System.out.print("- Nhập số điện thoại: ");
            this.setPhone(sc.nextLine());
            checkPhone();
        }
    }

    //check CMND
    String patternCMND = "^[0-3]\\d{8,11}$";

    public void checkCMND() {
        if (this.getCMND().matches(patternCMND)) {
            System.out.print("- Nhập email: ");
            this.setMail(sc.nextLine());
            checkMail();
        } else {
            System.out.println("CMND không hợp lệ!! Vui lòng nhập lại!!");
            System.out.println("");
            System.out.print("- Nhập CMND: ");
            this.setCMND(sc.nextLine());
            checkCMND();
        }
    }

    //add vị trí tự động
    public void autoAddAddress() {
        String[] cmndList = this.getCMND().split("");
        switch (Integer.parseInt(cmndList[0])) {
            case 0:
                switch (Integer.parseInt(cmndList[1])) {
                    case 1:
                        System.out.println("Hà Nội");
                        break;
                    case 2:
                        System.out.println("TP.HCM");
                        break;
                    case 3:
                        System.out.println("Hải Phòng");
                        break;
                    case 4:
                        System.out.println("Lai Châu");
                        break;
                    case 5:
                        System.out.println("Sơn La");
                        break;
                    case 6:
                        System.out.println("Lào Cai");
                        break;
                    case 7:
                        System.out.println("Hà Tuyên");
                        break;
                    case 8:
                        System.out.println("Lạng Sơn");
                        break;
                    case 9:
                        if (Integer.parseInt(cmndList[2]) == 5) {
                            System.out.println("Bắc Cạn");
                        } else if (Integer.parseInt(cmndList[2]) == 0 || Integer.parseInt(cmndList[2]) == 1) {
                            System.out.println("Thái Nguyên");
                        }
                        break;
                    default:
                        break;
                }
                break;
            case 1:
                switch (Integer.parseInt(cmndList[1])) {
                    case 0:
                        System.out.println("Quảng Ninh");
                        break;
                    case 1:
                        System.out.println("Hà Tây");
                        break;
                    case 2:
                        System.out.println("Thành Phố Bắc Giang/ Bắc Ninh");
                        break;
                    case 3:
                        System.out.println("Vĩnh Phúc");
                        break;
                    case 4:
                        System.out.println("Hải Dương");
                        break;
                    case 5:
                        System.out.println("Thành Phố Thái Bình/Yên Bái");
                        break;
                    case 6:
                        System.out.println("Hà Nam");
                        break;
                    case 7:
                        System.out.println("Thanh Hoá");
                        break;
                    case 8:
                        System.out.println("Nghệ An");
                        break;
                    case 9:
                        System.out.println("Thừa Thiên Huế/ Quảng Bình/ Quảng Trị");
                        break;
                    default:
                        break;
                }
                break;
            case 2:
                switch (Integer.parseInt(cmndList[1])) {
                    case 0:
                        System.out.println("Quảng Nam");
                        break;
                    case 1:
                        System.out.println("Bình Định");
                        break;
                    case 2:
                        System.out.println("Phú Yên");
                        break;
                    case 3:
                        if (Integer.parseInt(cmndList[2]) == 0 || Integer.parseInt(cmndList[2]) == 1) {
                            System.out.println("Gia Lai");
                        } else {
                            System.out.println("Kon Tum");
                        }
                        break;
                    case 4:
                        System.out.println("Đắk Lắk");
                        break;
                    case 5:
                        System.out.println("Lâm Đồng");
                        break;
                    case 6:
                        System.out.println("Ninh Thuận/Bình Thuận");
                        break;
                    case 7:
                        System.out.println("Đồng Nai/Bà Rịa - Vũng Tàu");
                        break;
                    case 9:
                        System.out.println("Tây Ninh");
                        break;
                    default:
                        break;
                }
                break;
            case 3:
                switch (Integer.parseInt(cmndList[1])) {
                    case 0:
                        System.out.println("Long An");
                        break;
                    case 1:
                        System.out.println("Tiền Giang");
                        break;
                    case 2:
                        System.out.println("Bến Tre");
                        break;
                    case 3:
                        System.out.println("Vĩnh Long");
                        break;
                    case 4:
                        System.out.println("Đồng Tháp");
                        break;
                    case 5:
                        System.out.println("An Giang");
                        break;
                    case 6:
                        System.out.println("Hậu Giang");
                        break;
                    case 8:
                        System.out.println("Bạc Liêu/Cà Mau");
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
    }

    public void input() {
        System.out.print("- Nhập tên: ");
        this.setName(sc.nextLine());
        System.out.print("- Nhập tuổi: ");
        this.setAge(sc.nextInt());
        sc.nextLine();
        System.out.print("- Nhập số điện thoại: ");
        this.setPhone(sc.nextLine());
        checkPhone();

    }

    public void display() {
        System.out.println("- Tên: " + this.getName());
        System.out.println("- Tuổi: " + this.getAge());
        System.out.println("- Số điện thoại: " + this.getPhone());
        System.out.println("- CMND: " + this.getCMND());
        System.out.println("- Email: " + this.getMail());
        System.out.print("- Quê quán: ");
        autoAddAddress();
    }
    
    public void displayF() {
        System.out.format("Tên: %s   Quê: %s   CMND/CCCD: unknow   "
                + "sđt: %s   Email: %s",this.getName(), this.getAddress(), 
                this.getPhone(), this.getMail());
    }
}
