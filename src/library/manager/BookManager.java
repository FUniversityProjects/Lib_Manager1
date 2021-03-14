/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.manager;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class BookManager {

    public ArrayList<Book> bookList = new ArrayList<>();
    public int numberOfBooks;
    public Books books = new Books();

    Scanner scan = new Scanner(System.in);

    public void addBooks() {
        int flag = 0;
        books.inputs();
        for (Book element : bookList) {
            if (element.getBookname().equals(books.books.get(0).getBookname())) {
                flag = 1;
            }
        }
        if (flag == 0) {
            bookList.addAll(books.books);
        } else {
            bookList.addAll(books.books);
            for (int i = 0; i < bookList.size(); i++) {
                if (bookList.get(i).getBookname().equals(books.books.get(0).getBookname())) {
                    bookList.get(i).setAmount(bookList.get(i).getAmount() + books.getNumberOfBooks());
                }
            }
            for (Book element : bookList) {
                if (element.getBookname().equals(books.books.get(0).getBookname())) {
                    for (int i = 0; i < books.books.size(); i++) {
                        books.books.get(i).setAmount(element.getAmount());
                    }
                    break;
                }
            }
        }

    }

    public void display() {
        for (Book element : bookList) {
            element.displayF();
        }
    }

    //Nếu file trống thì lỗi, Nhớ fix
    public void readFile() throws IOException, ClassNotFoundException {
        File file = new File("./Books.txt");
        bookList.removeAll(bookList);
        if (file.exists()) {
            FileInputStream fileI = new FileInputStream(file);
            ObjectInputStream objI = new ObjectInputStream(fileI);
            if (fileI.available() <= 0) {
                System.out.println("à");
            }
            while (fileI.available() > 0) {
                Book book = (Book) objI.readObject();
                bookList.add(0, book);

            }
            System.out.println("Đã load dữ liệu xong");
        } else {
            file.createNewFile();
        }

    }

    public void writeFile() throws FileNotFoundException, IOException {
        File file = new File("./Books.txt");
        if (file.exists()) {
            FileOutputStream fileO = new FileOutputStream(file);
            ObjectOutputStream objO = new ObjectOutputStream(fileO);
            for (Book element : bookList) {
                objO.writeObject(element);
            }
            System.out.println("Đã Save dữ liệu xong");
        } else {
            file.createNewFile();
        }
    }

    public void findByName() {
        int flag = 0;
        System.out.print("Nhập tên: ");
        String name = scan.nextLine();
        System.out.println("Kết quả: ");
        for (Book element : bookList) {
            if (element.getBookname().contains(name)) {
                element.displayF();
                flag = 1;
            }
        }
        if (flag == 0) {
            System.out.println("Không tìm thấy!");
        }
    }

    public void findByName1() {
        ArrayList<Book> editList = new ArrayList<>();
        int flag = 0;
        System.out.print("Nhập tên: ");
        String name = scan.nextLine();
        System.out.println("Kết quả: ");
        for (Book element : bookList) {
            if (element.getBookname().contains(name)) {
                element.displayF();
                editList.add(element);
                flag = 1;
            }
        }
        if (flag == 0) {
            System.out.println("Không tìm thấy!");
        } else {
            System.out.println("1. Xóa hết những sách này"
                    + "\n2. Hủy bỏ xóa"
                    + "\n\t Lựa chọn: ");
            int c = scan.nextInt();
            scan.nextLine();
        }
    }

    public void findByKind() {
        int flag = 0;
        System.out.print("Nhập thể loại: ");
        String kind = scan.nextLine();
        System.out.println("Kết quả: ");
        for (Book element : bookList) {
            if (element.getKind().contains(kind)) {
                element.displayF();
                flag = 1;
            }
        }
        if (flag == 0) {
            System.out.println("Không tìm thấy!");
        }
    }

    public void findByAuthor() {
        int flag = 0;
        System.out.print("Nhập tác giả: ");
        String author = scan.nextLine();
        System.out.println("Kết quả: ");
        for (Book element : bookList) {
            if (element.getAuthor().contains(author)) {
                element.displayF();
                flag = 1;
            }
        }
        if (flag == 0) {
            System.out.println("Không tìm thấy!");
        }
    }

    public void findByID() {
        int flag = 0;
        System.out.print("Nhập ID: ");
        String ID = scan.nextLine();
        System.out.println("Kết quả: ");
        for (Book element : bookList) {
            if (element.getID().contains(ID)) {
                element.displayF();
                flag = 1;
            }
        }
        if (flag == 0) {
            System.out.println("Không tìm thấy!");
        }
    }

    public void deleteByName() {
        ArrayList<Book> deleteList = new ArrayList<>();
        int flag = 0;
        System.out.print("Nhập tên sách cần xóa: ");
        String name = scan.nextLine();
        System.out.println("Kết quả: ");
        for (Book element : bookList) {
            if (element.getBookname().contains(name)) {
                element.displayF();
                deleteList.add(element);
                flag = 1;
            }
        }
        if (flag == 0) {
            System.out.println("Không tìm thấy!");
        } else {
            System.out.print("1. Xóa những sách này"
                    + "\n2. Hủy bỏ xóa"
                    + "\n\t Lựa chọn: ");
            int c = scan.nextInt();
            scan.nextLine();
            if (c == 1) {
                for (Book element : deleteList) {
                    for (int i = 0; i < bookList.size(); i++) {
                        if (element.getBookname().equals(bookList.get(i).getBookname())) {
                            bookList.get(i).setAmount(bookList.get(i).getAmount() - 1);
                        }
                    }
                }
                bookList.removeAll(deleteList);
            }
        }

    }

    public void deleteByID() {
        ArrayList<Book> deleteList = new ArrayList<>();
        int flag = 0;
        System.out.print("Nhập ID sách cần xóa: ");
        String ID = scan.nextLine();
        System.out.println("Kết quả: ");
        for (Book element : bookList) {
            if (element.getID().contains(ID)) {
                element.displayF();
                deleteList.add(element);
                flag = 1;
            }
        }
        if (flag == 0) {
            System.out.println("Không tìm thấy!");
        } else {
            System.out.println("1. Xóa những sách này"
                    + "\n2. Hủy bỏ xóa"
                    + "\n\t Lựa chọn: ");
            int c = scan.nextInt();
            scan.nextLine();
            if (c == 1) {
                for (Book element : deleteList) {
                    for (int i = 0; i < bookList.size(); i++) {
                        if (element.getBookname().equals(bookList.get(i).getBookname())) {
                            bookList.get(i).setAmount(bookList.get(i).getAmount() - 1);
                        }
                    }
                }
                bookList.removeAll(deleteList);
            }
        }

    }
    //Chưa perfect, xem lại
    public void editByID() {
        ArrayList<Book> editList = new ArrayList<>();
        int flag = 0;
        System.out.print("Nhập ID sách cần sửa: ");
        String ID = scan.nextLine();
        System.out.println("Kết quả: ");
        for (Book element : bookList) {
            if (element.getID().contains(ID)) {
                element.displayF();
                editList.add(element);
                flag = 1;
            }
        }
        if (flag == 0) {
            System.out.println("Không tìm thấy!");
        } else {
            System.out.println("1. Sửa thông tin những sách này"
                    + "\n2. Hủy bỏ"
                    + "\n\t Lựa chọn: ");
            int c = scan.nextInt();
            scan.nextLine();
            if (c == 1) {
                bookList.removeAll(editList);
                for (Book element : editList) {
                    for (int i = 0; i < bookList.size(); i++) {
                        if (element.getBookname().equals(bookList.get(i).getBookname())) {
                            bookList.get(i).setAmount(bookList.get(i).getAmount() - 1);
                        }
                    }
                    Book b = new Book();
                    System.out.println("Edit sách có ID: " + element.getID());
                    b.setID(element.getID());
                    b.setBookname(element.getBookname());
                    System.out.print("- Tác giả: ");
                    b.setAuthor(scan.nextLine());
                    System.out.print("- Thể loại: ");
                    b.setKind(scan.nextLine());
                    System.out.print("- Tình trạng: ");
                    b.setCondition(scan.nextLine());
                    System.out.print("- Giá tiền (nghìn VNĐ): ");
                    b.setMoney(scan.nextDouble());
                    scan.nextLine();
                    bookList.add(b);
                }
                
            }
        }
    }
    
    public void editByName() {
        ArrayList<Book> editList = new ArrayList<>();
        int flag = 0;
        System.out.print("Nhập ID sách cần sửa: ");
        String name = scan.nextLine();
        System.out.println("Kết quả: ");
        for (Book element : bookList) {
            if (element.getBookname().contains(name)) {
                element.displayF();
                editList.add(element);
                flag = 1;
            }
        }
        if (flag == 0) {
            System.out.println("Không tìm thấy!");
        } else {
            System.out.println("1. Sửa thông tin những sách này"
                    + "\n2. Hủy bỏ"
                    + "\n\t Lựa chọn: ");
            int c = scan.nextInt();
            scan.nextLine();
            if (c == 1) {
                bookList.removeAll(editList);
                for (Book element : editList) {
                    for (int i = 0; i < bookList.size(); i++) {
                        if (element.getBookname().equals(bookList.get(i).getBookname())) {
                            bookList.get(i).setAmount(bookList.get(i).getAmount() - 1);
                        }
                    }
                    Book b = new Book();
                    System.out.println("Edit sách có ID: " + element.getID());
                    b.setID(element.getID());
                    b.setBookname(element.getBookname());
                    System.out.print("- Tác giả: ");
                    b.setAuthor(scan.nextLine());
                    System.out.print("- Thể loại: ");
                    b.setKind(scan.nextLine());
                    System.out.print("- Tình trạng: ");
                    b.setCondition(scan.nextLine());
                    System.out.print("- Giá tiền (nghìn VNĐ): ");
                    b.setMoney(scan.nextDouble());
                    scan.nextLine();
                    bookList.add(b);
                }
                
            }
        }
    } 
}
