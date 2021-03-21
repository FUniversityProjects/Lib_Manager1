package library.manager;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class UserManager {

    private User user = new User();
    private Password pass = new Password();
    private ArrayList<User> userName = new ArrayList<>();
    private ArrayList<Password> passList = new ArrayList<>();
    private HashMap<User, Password> accList = new HashMap<User, Password>();
    public int numberOfUser;

    public UserManager() {
        numberOfUser = 3;
    }

    public ArrayList<User> getUserName() {
        return userName;
    }

    public void setUserName(ArrayList<User> userName) {
        this.userName = userName;
    }

    public ArrayList<Password> getPassList() {
        return passList;
    }

    public void setPassList(ArrayList<Password> passList) {
        this.passList = passList;
    }

    public HashMap<User, Password> getAccList() {
        return accList;
    }

    public void setAccList(HashMap<User, Password> accList) {
        this.accList = accList;
    }

    Scanner scan = new Scanner(System.in);

    public void a() {
        for (Password element : passList) {
            System.out.println(element.getPassword() + ": " + element.getID());
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

    /**
     * Tạo tài khoản người dùng mới
     */
    public void creatAcc() {
        user = new User();
        pass = new Password();
        user.input();
        if (checkExistUser(user.getUserName())) {
            System.out.println("Tên tài khoản đã tồn tại!");
            creatAcc();
        }
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
                if (elementUser.getID() == elementPassword.getID()) {
                    accList.put(elementUser, elementPassword);
                }
            }
        }
    }

    /**
     * Kiểm tra tài khoản đã tồn tại chưa
     *
     * @param userName tài khoản (String)
     * @return true nếu đã tồn tại, false nếu chưa tồn tại (boolean)
     */
    public boolean checkExistUser(String userName) {
        int flag = 0;
        for (User element : this.userName) {
            if (element.getUserName().equals(userName)) {
                flag = 1;
            }
        }

        return (flag == 1 ? true : false);
    }

    public void displayList() {
        System.out.println("----------- THÔNG TIN CỦA KHÁCH HÀNG -----------");
        for (User element : userName) {
            element.display();
        }
    }

    public void display() {
        System.out.println("----------- THÔNG TIN CỦA BẠN -----------");
        user.display();
    }

    /**
     * Tự cấp ID cho user mới
     *
     * @return ID (String)
     */
    public String autoID() {
        Calendar currentCalendar = Calendar.getInstance();
        int year = currentCalendar.get(Calendar.YEAR);
        int count = 1;
        if (userName.size() > 0) {
            String[] id = userName.get(userName.size() - 1).getID().split("");
            String a = id[id.length - 4] + id[id.length - 3] + id[id.length - 2] + id[id.length - 1];
            count = Integer.parseInt(a) + 1;
        }
        DecimalFormat formID = new DecimalFormat("0000");
        String autoID = formID.format(count);

        return "U" + year + autoID;
    }

    private boolean checkChangePass(String pass1) {
        System.out.println("Nhập mật khẩu mới: ");
        pass1 = scan.nextLine();
        System.out.println("Nhập lại mật khẩu mới: ");
        String pass2 = scan.next();
        if (pass1.equals(pass2)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Chưa xong, đợi fix
     */
    public void changePass() {
        System.out.print("- Nhập mật khẩu hiện tại: ");
        String currentPass = scan.nextLine();
        if (pass.getPassword().equals(currentPass)) {
            System.out.print("- Nhập mật khẩu mới: ");
            String newPass = scan.nextLine();
            System.out.print("- Nhập lại mật khẩu mới: ");
            String reNewPass = scan.nextLine();
            if(newPass.equals(reNewPass)) {
                readFilePass();
                for(Password element : passList) {
                    if (element.getID().equals(user.getID()) && element.getPassword().equals(pass.getPassword())) {
                        element.setPassword(newPass);
                    }
                }
                writeFilePass();
                System.out.println("Thay đổi mật khẩu thành công!");
            }
            else {
                System.out.println("Nhập sai!");
                changePass();
            }
        }
        else {
            System.out.println("Sai mật khẩu!");
        }
    }

    public void findUser() {
        ArrayList<User> selectUser = new ArrayList<User>();
        System.out.print("Nhap tu khoa: ");
        String key = scan.nextLine();
        int flag = 0;
        System.out.println("Kết quả tìm kiếm:");
        for (User element : userName) {
            if (element.getID().contains(key)) {
                element.display();
                selectUser.add(element);
                flag = 1;
            } else if (element.getUserName().contains(key)) {
                element.display();
                selectUser.add(element);
                flag = 1;
            } else if (element.getCMND().contains(key)) {
                element.display();
                flag = 1;
                selectUser.add(element);
            } else if (element.getPhone().contains(key)) {
                element.display();
                selectUser.add(element);
                flag = 1;
            } else if (element.getUserName().contains(key)) {
                element.display();
                selectUser.add(element);
                flag = 1;
            } else if (element.getName().contains(key)) {
                element.display();
                selectUser.add(element);
                flag = 1;
            }

        }
        int c = 0;
        if (flag == 0) {
            System.out.println("Không tìm thấy!");
        } else {
            System.out.println("1. Xóa tất cả người dùng này."
                    + "\n2. Sửa thông tin người dùng này."
                    + "\n3. Hủy bỏ.");
            c = scan.nextInt();
            scan.nextLine();
            if (c == 1) {
                userName.removeAll(selectUser);
                for (User element : selectUser) {
                    for (int i = 0; i < passList.size(); i++) {
                        if (passList.get(i).getID().equals(element.getID())) {
                            passList.remove(passList.get(i));
                        }
                    }
                }
            } else if (c == 2) {
                if (selectUser.size() > 1) {
                    System.out.println("Không thể sửa thông tin của nhiều người dùng một lúc!");
                } else if (selectUser.size() == 1) {
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

    public boolean login() throws FileNotFoundException, IOException, ClassNotFoundException {
        boolean flag = false;
        String tk, mk;
        File fileu = new File("./User.txt");
        File filep = new File("./P.txt");
        do {
            System.out.println("----------- LOGIN -----------");
            System.out.print("TÀI KHOẢN: ");
            tk = scan.nextLine();
            System.out.print("MẬT KHẨU: ");
            mk = scan.nextLine();
            if (filep.exists() && fileu.exists()) {
                FileInputStream fisu = new FileInputStream(fileu);
                FileInputStream fisp = new FileInputStream(filep);
                ObjectInputStream oisu = new ObjectInputStream(fisu);
                ObjectInputStream oisp = new ObjectInputStream(fisp);
                while (fisu.available() > 0) {
                    User u = (User) oisu.readObject();
                    if (u.getUserName().equals(tk)) {
                        while (fisp.available() > 0) {
                            Password p = (Password) oisp.readObject();
                            if (p.getPassword().equals(mk) && u.getID().equals(p.getID())) {
                                flag = true;
                                user = u;
                                pass = p;
                            }
                        }
                    }
                }
                if (!flag) {
                    System.out.println("Sai tên tài khoản hoặc mật khẩu!");
                }
            }
        } while (!flag);
        return flag;
    }

    public void borrowedBookList() {
        boolean flag = false;
        System.out.println("Sách đang mượn: ");
        for (Book element : user.borrowedBooks) {
            element.displayF();
            flag = true;
        }

        if (!flag) {
            System.out.println("Bạn chưa mượn sách!");
        }
    }

    public static boolean checkObjectExist(File file) {
        FileInputStream fis = null;
        boolean check = true;
        try {
            fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            if (ois.readObject() == null) {
                check = false;
            }
        } catch (FileNotFoundException ex) {
            check = false;
        } catch (IOException ex) {
            check = false;
        } catch (ClassNotFoundException ex) {
            check = false;
        }
        return check;
    }
}
