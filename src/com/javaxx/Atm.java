package com.javaxx;

class Atm extends Bank{
    String atm_name;
    int id;
    User user;
    int counter = 0;


    Atm(String atm_name,int id,Bank bank){
        super(bank.name,bank.branch, bank.users);
        this.atm_name = atm_name;
        this.id = id;

    }

    Atm(String atm_name,int id,User user, Bank bank){
        super(bank.name,bank.branch, bank.users);
        this.atm_name = atm_name;
        this.id = id;
        this.user = user;

    }

//

    boolean setUser(int acc,int pin){
        counter++;
        this.user = super.validateClient(acc,pin);

        if(this.user!=null){
            message("Account found");
            return  true;
        }
        else
            message("Account doesn't match:");

        return false;
    }


    void showOptions(){
        System.out.println("Welcome to"+atm_name);
        System.out.println("====OPTIONS====");
        System.out.println("1 Show User Details");
        System.out.println("2 Set Pin");
        System.out.println("3 Credit Cash");
        System.out.println("4 Withdraw Cash");
        System.out.println("5 Check Balance");
        System.out.println("6 Exit");
        System.out.println("7 Show All Transactions");
        System.out.println("8 Show last Transactions");
        System.out.println("9 Show User Transactions");
        System.out.println("CHOOSE =>");
    }



}