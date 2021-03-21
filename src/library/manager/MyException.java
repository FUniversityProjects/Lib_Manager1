/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.manager;

/**
 *
 * @author DELL
 */
public class MyException extends Exception{
    public MyException(String mess) {
        super(mess);
    }
    
    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
