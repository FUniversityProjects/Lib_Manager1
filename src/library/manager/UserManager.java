package library.manager;

import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
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

    public UserManager() throws IOException {
        numberOfUser = 0;
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

    public int numberOfUser() throws FileNotFoundException, IOException, ClassNotFoundException {
        numberOfUser = 0;
        File file = new File("./User.txt");
        FileInputStream fileI = null;
        ObjectInputStream objI = null;
        if (file.exists()) {
            User u;
            fileI = new FileInputStream(file);
            objI = new ObjectInputStream(fileI);
            while (fileI.available() > 0) {
                u = (User) objI.readObject();
                numberOfUser++;
            }
            objI.close();
            fileI.close();
        }
        return numberOfUser-1;
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

    public int login() throws FileNotFoundException, IOException, ClassNotFoundException {
        int flag = 0;
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
                            if (p.getPassword().equals(mk) && u.getID().equals(p.getID()) && !u.getIsAd()) {
                                flag = 1;
                                user = u;
                                pass = p;
                            } else if (p.getPassword().equals(mk) && u.getID().equals(p.getID()) && u.getIsAd()) {
                                flag = 2;
                                user = u;
                                pass = p;
                            }
                        }
                    }
                }
                if (flag == 0) {
                    System.out.println("Sai tên tài khoản hoặc mật khẩu!");
                }
            }
        } while (flag == 0);
        return flag;
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
        User user = new User();
        Password pass = new Password();
        user.input();
        if (checkExistUser(user.getUserName())) {
            System.out.println("Tên tài khoản đã tồn tại!");
            creatAcc();
        } else {
            user.setID(autoID());
            pass.setID(user.getID());
            pass.input();
            accList.put(user, pass);
            userName.add(user);
            passList.add(pass);
            writeFile();
        }
    }

    public void format() {
        User ad = new User();
        Password pass = new Password();
        ad.setID("A20210001");
        ad.setName("Admin");
        ad.setUserName("admin");
        ad.setIsAd(true);
        ad.setPhone("0388833303");
        ad.setCMND("366273867");
        ad.setMail("truongan147258@gmail.com");
        pass.setID(ad.getID());
        pass.setPassword("admin");
        userName.add(ad);
        passList.add(pass);
        writeFile();

        BookManager b = new BookManager();
        b.readFile();
        for (int i = 0; i < b.bookList.size(); i++) {
            b.bookList.get(i).setBorrowed(false);
        }
        b.writeFile();
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

    public void displayList() throws IOException, FileNotFoundException, ClassNotFoundException {
        System.out.println("----------- DANH SÁCH KHÁCH HÀNG (" + this.numberOfUser() + ") -----------");
        for (User element : userName) {
            if(!element.getIsAd()) {
                element.displayList();
            }
        }
    }

    public void display() {
        System.out.println("----------- THÔNG TIN CỦA BẠN -----------");
        user.display();
    }

    /**
     * Tự cấp ID cho user mới.
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
     * Đổi mật khẩu, đã fix.
     */
    public void changePass() {
        System.out.print("- Nhập mật khẩu hiện tại: ");
        String currentPass = scan.nextLine();
        if (pass.getPassword().equals(currentPass)) {
            System.out.print("- Nhập mật khẩu mới: ");
            String newPass = scan.nextLine();
            System.out.print("- Nhập lại mật khẩu mới: ");
            String reNewPass = scan.nextLine();
            if (newPass.equals(reNewPass)) {
                readFilePass();
                for (Password element : passList) {
                    if (element.getID().equals(user.getID()) && element.getPassword().equals(pass.getPassword())) {
                        element.setPassword(newPass);
                    }
                }
                writeFilePass();
                System.out.println("Thay đổi mật khẩu thành công!");
            } else {
                System.out.println("Nhập sai!");
                changePass();
            }
        } else {
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
            if (element.getID().contains(key) && !element.getIsAd()) {
                element.displayList();
                selectUser.add(element);
                flag = 1;
            } else if (element.getUserName().contains(key) && !element.getIsAd()) {
                element.displayList();
                selectUser.add(element);
                flag = 1;
            } else if (element.getCMND().contains(key) && !element.getIsAd()) {
                element.displayList();
                flag = 1;
                selectUser.add(element);
            } else if (element.getPhone().contains(key) && !element.getIsAd()) {
                element.displayList();
                selectUser.add(element);
                flag = 1;
            } else if (element.getUserName().contains(key) && !element.getIsAd()) {
                element.displayList();
                selectUser.add(element);
                flag = 1;
            } else if (element.getName().contains(key) && !element.getIsAd()) {
                element.displayList();
                selectUser.add(element);
                flag = 1;
            }

        }
        int c = 0;
        if (flag == 0) {
            System.out.println("Không tìm thấy!");
        } else {
            System.out.print("1. Xóa tất cả người dùng này."
                    + "\n2. Sửa thông tin người dùng này."
                    + "\n3. Xem thông tin chi tiết."
                    + "\n4. Hủy bỏ."
                    + "\n\tLựa chọn của bạn:");
            c = scan.nextInt();
            scan.nextLine();
            if (c == 1) {
                userName.removeAll(selectUser);
                for (User element : selectUser) {
                    for (int i = 0; i < passList.size(); i++) {
                        if (passList.get(i).getID().equals(element.getID())) {
                            passList.remove(passList.get(i));
                            writeFile();
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
                    writeFile();
                }
            } else if (c == 3) {
                System.out.println("--------THÔNG TIN KHÁCH HÀNG-------");
                for (User element : selectUser) {
                    element.display();
                    boolean l = false;
                    System.out.println("Sách đang mượn: ");
                    for (Book e : element.borrowedBooks) {
                        e.displayBorrow();
                        l = true;
                    }

                    if (!l) {
                        System.out.println("Chưa mượn sách!");
                    }
                }
            }
        }
    }

    public void borrowedBookList() {
        boolean flag = false;
        System.out.println("Sách đang mượn: ");
        for (Book element : user.borrowedBooks) {
            element.displayBorrow();
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

    public void borrowBook() {
        Calendar day = Calendar.getInstance();
        SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
        BookManager b = new BookManager();
        b.readFile();
        Book bb = new Book();
        User u = new User();
        int i = 0;
        System.out.print("Nhập ID khách hàng: ");
        String idu = scan.nextLine();
        for (User element : userName) {
            if (element.getID().contains(idu) && !element.getIsAd()) {
                i++;
                element.displayList();
                u = element;
            }
        }
        if (i == 1) {
            i = 0;
            System.out.print("Nhập ID sách: ");
            String idb = scan.nextLine();

            for (Book element : b.bookList) {
                if (element.getID().contains(idb)) {
                    i++;
                    element.displayF();
                    bb = element;
                }

            }
            if (i == 1) {
                System.out.print("1. Cho mượn."
                        + "\n2. Hủy bỏ."
                        + "\n\tLựa chọn: ");
                int c = scan.nextInt();
                scan.nextLine();
                if (c == 1) {
                    if (!bb.getBorrowed()) {
                        bb.setDateBorrow(form.format(day.getTime()));
                        day.add(day.DATE, 15);
                        bb.setDateRefund(form.format(day.getTime()));
                        for (int j = 0; j < userName.size(); j++) {
                            if (userName.get(j).getID().equals(u.getID())) {
                                userName.get(j).setBorrow(true);
                                userName.get(j).borrowedBooks.add(bb);
                            }
                        }
                        for (int k = 0; k < b.bookList.size(); k++) {
                            if (b.bookList.get(k).getID().equals(bb.getID())) {
                                b.bookList.get(k).setBorrowed(true);

                            }
                        }
                        b.writeFile();
                        writeFile();
                    }
                    else {
                        System.out.println("Sách này hiện không có sẵn!");
                    }
                }
            } 
            else if (i == 0) {
                System.out.println("Không tìm thấy sách!");
            }
            else {
                System.out.println("Chỉ được chọn 1 sách!");
            }
        } 
        else if(i == 0) {
            System.out.println("Không tìm thấy khách hàng!");
        }
        else {
            System.out.println("Chỉ chọn 1 khách hàng.");
        }
    }

    public void reFund() {
        int i = 0;
        Calendar d = Calendar.getInstance();
        SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
        BookManager b = new BookManager();
        b.readFile();
        Book bb = new Book();
        System.out.print("Nhập ID sách: ");
        String idb = scan.nextLine();
        for (Book element : b.bookList) {
            if (element.getID().contains(idb) && element.getBorrowed()) {
                i++;
                element.displayF();
                bb = element;
            }
        }
        if (i == 1) {
            //For each không được thì đổi thành for thường.
            for (User element : userName) {
                for (int k = 0; k < element.borrowedBooks.size(); k++) {
                    if (element.borrowedBooks.get(k).getID().equals(bb.getID()) && element.borrowedBooks.get(k).getBorrowed()) {
                        ArrayList<Book> book_delete = new ArrayList<>();
                        book_delete.add(element.borrowedBooks.get(k));
                        System.out.println("Người mượn: " + element.getName() + " (ID: " + element.getID() + ")");
                        
                        if (computeDeadline(bb.getDateRefund()) > 0) {
                            System.out.println("Sớm: " + computeDeadline(bb.getDateRefund()) + " ngày");
                        } else if (computeDeadline(bb.getDateRefund()) < 0) {
                            System.out.println("Trễ: " + computeDeadline(bb.getDateRefund()) + " ngày");
                        } else {
                            System.out.println("Đúng hạn!");
                        }
                        System.out.print("1. Trả sách."
                                + "\n2. Hủy bỏ."
                                + "\n\tLựa chọn: ");
                        int c = scan.nextInt();
                        scan.nextLine();
                        if (c == 1) {
                            element.borrowedBooks.remove(element.borrowedBooks.get(k));
                            if (element.borrowedBooks.size() == 0) {
                                element.setBorrow(false);
                            }
                            for (int j = 0; j < b.bookList.size(); j++) {
                                if (b.bookList.get(j).getID().equals(bb.getID())) {
                                    b.bookList.get(j).setBorrowed(false);
                                    b.bookList.get(j).setDateBorrow(null);
                                    b.bookList.get(j).setDateRefund(null);
                                }
                            }
                            writeFile();
                            b.writeFile();
                            break;
                        }
                    }
                    
                }
            }
        } 
        else if (i == 0) {
            System.out.println("Không tìm thấy sách!");
        }
        else {
            System.out.println("Chỉ được chọn 1 sách!");
        }
    }
    
    public void reportUser() throws IOException, FileNotFoundException, ClassNotFoundException {
        System.out.println("Tổng số khách hàng: " + numberOfUser());
    }
    
    public void reportBook() {
        BookManager b = new BookManager();
        System.out.println("Tổng số sách hiện có: "+b.numOfBook());
    }
    
    public int computeDeadline(String ngayTra) {
        Calendar d = Calendar.getInstance();
        SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
        String[] now = form.format(d.getTime()).split("/");
        String[] ngayTral = ngayTra.split("/");
        LocalDate nowd = LocalDate.of(Integer.parseInt(now[now.length -1]), Integer.parseInt(now[now.length -2]), Integer.parseInt(now[now.length -3]));
        LocalDate ngayTrad = LocalDate.of(Integer.parseInt(ngayTral[ngayTral.length -1]), Integer.parseInt(ngayTral[ngayTral.length -2]), Integer.parseInt(ngayTral[ngayTral.length -3]));
        Period compare = Period.between(nowd, ngayTrad);
        return compare.getDays();
    }
    
    public void reportBorrowedBook() {
        
    }
    
    public void reportUserOverDeadline() {
        
    }
}
