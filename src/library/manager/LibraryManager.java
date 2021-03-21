/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.manager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;

/**
 *
 * @author ACER
 */
public class LibraryManager {

    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
//        MenuManagement m = new MenuManagement();
//        m.loginMenu();
//            UserManager u = new UserManager();
//            u.format();
    
        Calendar d = Calendar.getInstance();
        SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
        LocalDate a = LocalDate.of(2021, 03, 15);
        String g = form.format(d.getTime());
        String[] i = g.split("/");
        DecimalFormat formID = new DecimalFormat("0000");
        LocalDate b = LocalDate.of(Integer.parseInt(i[i.length-1]), Integer.parseInt(i[i.length-2]),Integer.parseInt(i[i.length-3]));
        System.out.println(b);
        Period different = Period.between(b, a);
        System.out.println(different.getDays()*24);
    }
}
