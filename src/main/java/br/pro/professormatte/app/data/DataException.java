/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pro.professormatte.app.data;

/**
 *
 * @author marcio
 */
public class DataException extends Exception {

    public DataException(String msg) {
        super(msg);
    }

    public DataException(Throwable throwable) {
        super(throwable);
    }

    public DataException(String msg, Throwable throwable) {
        super(msg, throwable);
    }
    
    
}
