package com.javaxx;

class User extends Bank{
    String name;
    int pin;
    int bank_account;
    double amount = 0;

    User(String name,int bank_account,Bank bank){
        super(bank.name,bank.branch);
        this.name = name;
        this.bank_account = bank_account;
    }

    User(String name,int bank_account,int pin,double amount,Bank bank){
        super(bank.name,bank.branch);
        this.name = name;
        this.pin = pin;
        this.amount = amount;
        this.bank_account = bank_account;
    }

    void showAmount(){
        System.out.println();
    }
    void credit(double amounts){
        this.amount += amounts;
    }

    void debit(double amounts){
        this.amount-=amounts;
    }

    void changePin(int pinchange){
        this.pin = pinchange;
        message("In user change pin"+this.pin);
    }

    void showUserDetails(){
        System.out.println("Name: "+name);
        System.out.println("pin: "+pin);
        System.out.println("BankAccount: "+bank_account);
        System.out.println("Amount: "+amount);
        show_bank();
    }
}