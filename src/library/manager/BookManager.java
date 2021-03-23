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

    transient Scanner scan = new Scanner(System.in);

    public int numOfBook() {
        readFile();
        return bookList.size();
    }
    
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
        writeFile();

    }

    public void display() {
        readFile();
        boolean flag = false;
        System.out.println("Danh sách: ");
        for (Book element : bookList) {
            element.displayF();
            flag = true;
        }
        if (!flag) {
            System.out.println("Danh sách trống!");
        }
    }

    //Đã fix
    public void readFile() {
        File file = new File("./Books.txt");
        FileInputStream fileI = null;
        ObjectInputStream objI = null;
        bookList.removeAll(bookList);
        try {
            if (file.exists()) {
                fileI = new FileInputStream(file);
                objI = new ObjectInputStream(fileI);
                while (fileI.available() > 0) {
                    Book book = (Book) objI.readObject();
                    bookList.add(0, book);
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

    public void writeFile() {
        File file = new File("./Books.txt");
        FileOutputStream fileO = null;
        ObjectOutputStream objO = null;
        try {
            if (file.exists()) {
                fileO = new FileOutputStream(file);
                objO = new ObjectOutputStream(fileO);
                for (Book element : bookList) {
                    objO.writeObject(element);
                }
                objO.close();
                fileO.close();
                System.out.println("Đã Save dữ liệu xong");
            } else {
                file.createNewFile();
                fileO = new FileOutputStream(file);
                objO = new ObjectOutputStream(fileO);
                for (Book element : bookList) {
                    objO.writeObject(element);
                }
                objO.close();
                fileO.close();
                System.out.println("Đã Save dữ liệu xong");
            }
        } catch (IOException e) {

        }
    }

    public void findBook() {
        int flag = 0;
        System.out.print("Nhập tên: ");
        String key = scan.nextLine();
        System.out.println("Kết quả: ");
        for (Book element : bookList) {
            if (element.getBookname().contains(key)) {
                element.displayF();
                flag = 1;
            } else if (element.getKind().contains(key)) {
                element.displayF();
                flag = 1;
            } else if (element.getAuthor().contains(key)) {
                element.displayF();
                flag = 1;
            } else if (element.getID().contains(key)) {
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
                writeFile();
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
                writeFile();
            }
        }

    }

    //Chưa perfect, xem lại
    //Đã fix, chưa biết perfect chưa
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
            System.out.print("1. Sửa thông tin những sách này"
                    + "\n2. Hủy bỏ"
                    + "\n\t Lựa chọn: ");
            int c = scan.nextInt();
            scan.nextLine();
            if (c == 1) {

                for (Book element : editList) {
                    for (int i = 0; i < bookList.size(); i++) {
                        if (element.getID().equals(bookList.get(i).getID())) {
                            System.out.println("Edit sách có ID: " + element.getID());
                            System.out.print("- Tác giả: ");
                            bookList.get(i).setAuthor(scan.nextLine());
                            System.out.print("- Thể loại: ");
                            bookList.get(i).setKind(scan.nextLine());
                            System.out.print("- Tình trạng: ");
                            bookList.get(i).setCondition(scan.nextLine());
                            System.out.print("- Giá tiền (nghìn VNĐ): ");
                            bookList.get(i).setMoney(scan.nextDouble());
                            scan.nextLine();
                        }
                    }
                }
                writeFile();

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
                writeFile();

            }
        }
    }

}
