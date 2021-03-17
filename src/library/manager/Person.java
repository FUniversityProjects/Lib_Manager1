/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.manager;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class Person implements Serializable {

    private int age;
    private String name;
    private String phone;
    private String CMND;
    private String mail;
    private String Address;
    private boolean isAd;
    transient Scanner sc = new Scanner(System.in);

    public Person() {
    }

    public Person(double money, int age, String phone, String CMND, String mail, String Address) {
        this.age = age;
        this.phone = phone;
        this.CMND = CMND;
        this.mail = mail;
        this.Address = Address;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    //check email
    String patternEmail = "^[a-zA-Z]\\w*@[a-zA-Z]\\w*(\\.[a-zA-Z]\\w*)+$";

    public void checkMail() {
        //nếu mail hợp lệ thì cho qua
        if (this.getMail().matches(patternEmail)) {
            System.out.print("");
            //nếu mail không hợp lệ thì yêu cầu nhập lại và check mail
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
        //nếu số điện thoại hợp lệ, cho nhập infor tiếp theo
        if (this.getPhone().matches(patternPhone)) {
            System.out.print("- Nhập CMND: ");
            this.setCMND(sc.nextLine());
            checkCMND();
            //nếu sai yêu cầu nhập lại và check
        } else {
            System.out.println("Số điện thoại không hợp lệ!! Vui lòng nhập lại!!");
            System.out.print("- Nhập số điện thoại: ");
            this.setPhone(sc.nextLine());
            checkPhone();
        }
    }

    //check CMND
    String patternCMND = "^[0-3]\\d{8}$";

    public void checkCMND() {
        //nếu số CMND hợp lệ thì cho nhập tiếp thông tin tiếp theo
        if (this.getCMND().matches(patternCMND)) {
            System.out.print("- Nhập email: ");
            this.setMail(sc.nextLine());
            checkMail();
            //nếu CMND không hợp lệ thì cho check CCCD
        } else {
            checkCCCD();
        }
    }

    //check CCCD
    String patternCCCD = "^(0)\\d{11}$";

    public void checkCCCD() {
        //từ CMND qua nếu số vừa đủ 12 số thì số CCCD hợp lệ, sẽ cho nhập infor tiếp theo
        if (this.getCMND().matches(patternCCCD)) {
            System.out.print("- Nhập email: ");
            this.setMail(sc.nextLine());
            checkMail();
            //nếu sai yêu cầu nhập lại và quay lại check CMND
        } else {
            System.out.println("Dữ liệu không hợp lệ!! Vui lòng nhập lại!!");
            System.out.print("- Nhập CMND: ");
            this.setCMND(sc.nextLine());
            checkCMND();
        }
    }

    //add address tự động dựa theo số CMND
    public void autoAddAddressByCMND() {
        String[] cmndList = this.getCMND().split("");
        switch (Integer.parseInt(cmndList[0])) {
            case 0:
                switch (Integer.parseInt(cmndList[1])) {
                    case 1:
                        System.out.print("Hà Nội");
                        break;
                    case 2:
                        System.out.print("TP.HCM");
                        break;
                    case 3:
                        System.out.print("Hải Phòng");
                        break;
                    case 4:
                        System.out.print("Lai Châu");
                        break;
                    case 5:
                        System.out.print("Sơn La");
                        break;
                    case 6:
                        System.out.print("Lào Cai");
                        break;
                    case 7:
                        System.out.print("Hà Tuyên");
                        break;
                    case 8:
                        System.out.print("Cao Bằng / Lạng Sơn");
                        break;
                    case 9:
                        if (Integer.parseInt(cmndList[2]) == 5) {
                            System.out.print("Bắc Cạn");
                        } else if (Integer.parseInt(cmndList[2]) == 0 || Integer.parseInt(cmndList[2]) == 1) {
                            System.out.print("Thái Nguyên");
                        }
                        break;
                    default:
                        break;
                }
                break;
            case 1:
                switch (Integer.parseInt(cmndList[1])) {
                    case 0:
                        System.out.print("Quảng Ninh");
                        break;
                    case 1:
                        System.out.print("Hà Tây");
                        break;
                    case 2:
                        System.out.print("Thành Phố Bắc Giang / Bắc Ninh");
                        break;
                    case 3:
                        System.out.print("Vĩnh Phúc");
                        break;
                    case 4:
                        System.out.print("Hải Dương");
                        break;
                    case 5:
                        System.out.print("Thành Phố Thái Bình / Yên Bái");
                        break;
                    case 6:
                        System.out.print("Hà Nam");
                        break;
                    case 7:
                        System.out.print("Thanh Hoá");
                        break;
                    case 8:
                        System.out.print("Nghệ An");
                        break;
                    case 9:
                        System.out.print("Thừa Thiên Huế / Quảng Bình / Quảng Trị");
                        break;
                    default:
                        break;
                }
                break;
            case 2:
                switch (Integer.parseInt(cmndList[1])) {
                    case 0:
                        System.out.print("Quảng Nam");
                        break;
                    case 1:
                        System.out.print("Bình Định");
                        break;
                    case 2:
                        System.out.print("Phú Yên");
                        break;
                    case 3:
                        if (Integer.parseInt(cmndList[2]) == 0 || Integer.parseInt(cmndList[2]) == 1) {
                            System.out.print("Gia Lai");
                        } else {
                            System.out.print("Kon Tum");
                        }
                        break;
                    case 4:
                        System.out.print("Đắk Lắk");
                        break;
                    case 5:
                        System.out.print("Lâm Đồng");
                        break;
                    case 6:
                        System.out.print("Ninh Thuận / Bình Thuận");
                        break;
                    case 7:
                        System.out.print("Đồng Nai / Bà Rịa - Vũng Tàu");
                        break;
                    case 9:
                        System.out.print("Tây Ninh");
                        break;
                    default:
                        break;
                }
                break;
            case 3:
                switch (Integer.parseInt(cmndList[1])) {
                    case 0:
                        System.out.print("Long An");
                        break;
                    case 1:
                        System.out.print("Tiền Giang");
                        break;
                    case 2:
                        System.out.print("Bến Tre");
                        break;
                    case 3:
                        System.out.print("Vĩnh Long");
                        break;
                    case 4:
                        System.out.print("Đồng Tháp");
                        break;
                    case 5:
                        System.out.print("An Giang");
                        break;
                    case 6:
                        System.out.print("Hậu Giang");
                        break;
                    case 8:
                        System.out.print("Bạc Liêu / Cà Mau");
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
    }

    //add address tự động dựa theo CCCD
    public void autoAddAddressByCCCD() {
        String[] arrCCCD = {" ", "Hà Nội", "Hà Giang", "Cao Bằng", "Bắc Kạn", "Tuyên Quang", "Lào Cai",
            "Điện Biên", "Lai Châu", "Sơn La", "Yên Bái", "Hoà Bình", "Thái Nguyên", "Lạng Sơn", "Quảng Ninh",
            "Bắc Giang", "Phú Thọ", "Vĩnh Phúc", "Bắc Ninh", "Hải Dương", "Hải Phòng", "Hưng Yên", "Thái Bình", "Hà Nam",
            "Nam Định", "Ninh Bình", "Thanh Hoá", "Nghệ An", "Hà Tĩnh", "Quảng Bình", "Quảng Trị", "Thừa Thiên Huế", "Đà Nẵng",
            "Quảng Nam", "Quảng Ngãi", "Bình Định", "Phú Yên", "Khánh Hoà", "Ninh Thuận", "Bình Thuận", "Kon Tum", "Gia Lai",
            "Đắk Lắk", "Đắk Nông", "Lâm Đồng", "Bình Phước", "Tây Ninh", "Bình Dương", "Đồng Nai", "Bà Rịa - Vũng Tàu", "HCM",
            "Long An", "Tiền Giang", "Bến Tre", "Trà Vinh", "Vĩnh Long", "Đồng Tháp", "An Giang", "Kiên Giang", "Cần Thơ",
            "Hậu Giang", "Sóc Trăng", "Bạc Liêu", "Cà Mau"};
        String[] list = this.getCMND().split("");
        int element2 = Integer.parseInt(list[1]);
        int element3 = Integer.parseInt(list[2]);
        if (this.getCMND().matches(patternCCCD)) {
            if (element2 == 0) {
                if (element3 == 1) {
                    System.out.print(arrCCCD[1]);
                } else if (element3 == 2) {
                    System.out.print(arrCCCD[2]);
                } else if (element3 == 4) {
                    System.out.print(arrCCCD[3]);
                } else if (element3 == 6) {
                    System.out.print(arrCCCD[4]);
                } else if (element3 == 8) {
                    System.out.print(arrCCCD[5]);
                }
            } else if (element2 == 1) {
                if (element3 == 0) {
                    System.out.print(arrCCCD[6]);
                } else if (element3 == 1) {
                    System.out.print(arrCCCD[7]);
                } else if (element3 == 2) {
                    System.out.print(arrCCCD[8]);
                } else if (element3 == 4) {
                    System.out.print(arrCCCD[9]);
                } else if (element3 == 5) {
                    System.out.print(arrCCCD[10]);
                } else if (element3 == 7) {
                    System.out.print(arrCCCD[11]);
                } else if (element3 == 9) {
                    System.out.print(arrCCCD[12]);
                }
            } else if (element2 == 2) {
                if (element3 == 0) {
                    System.out.print(arrCCCD[13]);
                } else if (element3 == 2) {
                    System.out.print(arrCCCD[14]);
                } else if (element3 == 4) {
                    System.out.print(arrCCCD[15]);
                } else if (element3 == 5) {
                    System.out.print(arrCCCD[16]);
                } else if (element3 == 6) {
                    System.out.print(arrCCCD[17]);
                } else if (element3 == 7) {
                    System.out.print(arrCCCD[18]);
                }
            } else if (element2 == 3) {
                if (element3 == 0) {
                    System.out.print(arrCCCD[19]);
                } else if (element3 == 1) {
                    System.out.print(arrCCCD[20]);
                } else if (element3 == 3) {
                    System.out.print(arrCCCD[21]);
                } else if (element3 == 4) {
                    System.out.print(arrCCCD[22]);
                } else if (element3 == 5) {
                    System.out.print(arrCCCD[23]);
                } else if (element3 == 6) {
                    System.out.print(arrCCCD[24]);
                } else if (element3 == 7) {
                    System.out.print(arrCCCD[25]);
                } else if (element3 == 8) {
                    System.out.print(arrCCCD[26]);
                }
            } else if (element2 == 4) {
                if (element3 == 0) {
                    System.out.print(arrCCCD[27]);
                } else if (element3 == 2) {
                    System.out.print(arrCCCD[28]);
                } else if (element3 == 4) {
                    System.out.print(arrCCCD[29]);
                } else if (element3 == 5) {
                    System.out.print(arrCCCD[30]);
                } else if (element3 == 6) {
                    System.out.print(arrCCCD[31]);
                } else if (element3 == 8) {
                    System.out.print(arrCCCD[32]);
                } else if (element3 == 9) {
                    System.out.print(arrCCCD[33]);
                }
            } else if (element2 == 5) {
                if (element3 == 1) {
                    System.out.print(arrCCCD[34]);
                } else if (element3 == 2) {
                    System.out.print(arrCCCD[35]);
                } else if (element3 == 4) {
                    System.out.print(arrCCCD[36]);
                } else if (element3 == 6) {
                    System.out.print(arrCCCD[37]);
                } else if (element3 == 8) {
                    System.out.print(arrCCCD[38]);
                }
            } else if (element2 == 6) {
                if (element3 == 0) {
                    System.out.print(arrCCCD[39]);
                } else if (element3 == 2) {
                    System.out.print(arrCCCD[40]);
                } else if (element3 == 4) {
                    System.out.print(arrCCCD[41]);
                } else if (element3 == 6) {
                    System.out.print(arrCCCD[42]);
                } else if (element3 == 7) {
                    System.out.print(arrCCCD[43]);
                } else if (element3 == 8) {
                    System.out.print(arrCCCD[44]);
                }
            } else if (element2 == 7) {
                if (element3 == 0) {
                    System.out.print(arrCCCD[45]);
                } else if (element3 == 2) {
                    System.out.print(arrCCCD[46]);
                } else if (element3 == 4) {
                    System.out.print(arrCCCD[47]);
                } else if (element3 == 5) {
                    System.out.print(arrCCCD[48]);
                } else if (element3 == 7) {
                    System.out.print(arrCCCD[49]);
                } else if (element3 == 9) {
                    System.out.print(arrCCCD[50]);
                }
            } else if (element2 == 8) {
                if (element3 == 0) {
                    System.out.print(arrCCCD[51]);
                } else if (element3 == 2) {
                    System.out.print(arrCCCD[52]);
                } else if (element3 == 3) {
                    System.out.print(arrCCCD[53]);
                } else if (element3 == 4) {
                    System.out.print(arrCCCD[54]);
                } else if (element3 == 6) {
                    System.out.print(arrCCCD[55]);
                } else if (element3 == 7) {
                    System.out.print(arrCCCD[56]);
                } else if (element3 == 9) {
                    System.out.print(arrCCCD[57]);
                }
            } else if (element2 == 9) {
                if (element3 == 1) {
                    System.out.print(arrCCCD[58]);
                } else if (element3 == 2) {
                    System.out.print(arrCCCD[59]);
                } else if (element3 == 3) {
                    System.out.print(arrCCCD[60]);
                } else if (element3 == 4) {
                    System.out.print(arrCCCD[61]);
                } else if (element3 == 5) {
                    System.out.print(arrCCCD[62]);
                } else if (element3 == 6) {
                    System.out.print(arrCCCD[63]);
                }
            }
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
        if (this.getCMND().length() == 9) {
            autoAddAddressByCMND();
        } else if (this.getCMND().length() == 12) {
            autoAddAddressByCCCD();
        }
    }

    public void displayF() {
        System.out.print("Tên: "+this.getName() + "   ");
        System.out.print("SĐT: "+this.getPhone() + "   ");
        System.out.print("CMND: "+this.getCMND() + "   ");
        System.out.print("Email: "+this.getMail() + "   ");
    }
}
