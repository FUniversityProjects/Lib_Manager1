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
    private String mail;
    private String location;
    private boolean isAd;
    Scanner sc = new Scanner(System.in);

    public Person() {
    }

    public Person(double money, int age, String phone, String CMND, String mail, String location) {
        this.age = age;
        this.phone = phone;
        this.CMND = CMND;
        this.mail = mail;
        this.location = location;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    //kiểm tra email
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
        } else {
            System.out.println("Số điện thoại không hợp lệ!! Vui lòng nhập lại!!");
            System.out.print("- Nhập số điện thoại: ");
            this.setPhone(sc.nextLine());
            checkPhone();
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
        System.out.print("- Nhập email: ");
        this.setMail(sc.nextLine());
        checkMail();
    }

    public void display() {
        System.out.println("- Tên: " + this.getName());
        System.out.println("- Tuổi: " + this.getAge());
        System.out.println("- Số điện thoại: " + this.getPhone());
        System.out.println("- CMND: " + this.getCMND());
        System.out.println("- Email: " + this.getMail());
    }
}
