package com.telran.a03_02_20;

import android.app.AlertDialog;

public class BankAccount {
    private int id;
    private String owner;
    private double balance;


    public BankAccount id(int id){
        this.id = id;
        return this;
    }

    public BankAccount balance(double balance){
        this.balance = balance;
        return this;
    }

    public BankAccount owner(String owner){
        this.owner = owner;
        return this;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", owner='" + owner + '\'' +
                ", balance=" + balance +
                '}';
    }
}
