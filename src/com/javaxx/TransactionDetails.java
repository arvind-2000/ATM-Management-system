package com.javaxx;

import java.util.Date;
import java.util.Scanner;

class TransactionDetails extends  Atm{
    Date date;
    String description;
    TransactionDetails[] transactionDetails;
    TransactionDetails(Atm atm){
        super(atm.name, atm.id,atm);

    }

    TransactionDetails(Date date,String description,Atm atm){
        super(atm.name, atm.id,atm.user,atm);
        this.date = date;
        this.description = description;

    }

    //Transaction operations

    void doTransactions(int choose){
        this.date = new Date();
        Scanner s = new Scanner(System.in);
        switch (choose){
            case 1:
                this.description = "Show user details";
                super.user.showUserDetails();
                break;
            case 2:
                message("Enter your pin: ");

                int input = s.nextInt();
                user.changePin(input);

                this.description = "Change Pin";
                break;
            case 3:
                message("Enter amount to credit: ");
                double cash = s.nextDouble();
                super.user.credit(cash);
                this.description = "Credited Rs."+cash;
                //do something
                break;

            case 4:
                message("Enter amount to debit: ");
                cash = s.nextDouble();
                super.user.debit(cash);
                this.description = "Debited Rs."+cash;
                break;
            case 5:
                message("Display Balance: ");
                super.user.showUserDetails();
                this.description = "Request balance enquiry";
                break;
            case 6:
                message("Exited: ");
                break;
            case 7:
                message("Show All Transactions: ");
                showTransactionDetailsAll();
                break;
            case 8:
                message("Show Last Transaction: ");
                showTransactionDetails();
                break;
            case 9:
                message("Show User Transaction: ");
                showTransactionDetailsUser();
                break;
            default:
                message("Your options dont match\nI understand everyone got different options.\nTry Again");
                break;


        }

        System.out.println("Enter any key to continue: ");
        new Scanner(System.in).nextLine();

    }




    void showTransactionDetails(){
        if(description==null){
         message("No Transactions to show");
         return;
        }
        System.out.println(date.toString());
        System.out.println(description);
        user.showUserDetails();
        show_bank();
    }

    void showTransactionDetails(TransactionDetails trans){
        if(trans == null){
            message("NO TRANSACTIONS TO SHOW");
        }else {
            System.out.println(trans.date.toString());
            System.out.println(trans.description);
            trans.user.showUserDetails();
            trans.show_bank();
        }

    }

    void showTransactionDetailsAll(){
        if(transactionDetails!=null){
            for(TransactionDetails t:transactionDetails){
                System.out.println("Transaction ====");
                showTransactionDetails(t);
            }
        }else
            message("NO TRANSACTIONS TO SHOW");

    }

    void showTransactionDetailsUser(){
        if(transactionDetails!=null){
            for(TransactionDetails t:transactionDetails){
                if(t.user.bank_account==user.bank_account){
                    showTransactionDetails(t);
                }
            }
        }else
            message("NO TRANSACTIONS TO SHOW");

    }

        void addTransaction(TransactionDetails addtransactions){
        TransactionDetails[] trans = transactionDetails;
        transactionDetails = new TransactionDetails[trans==null?1:trans.length+1];
        if(trans!=null){
            for(int i = 0;i<trans.length;i++){
                this.transactionDetails[i] = trans[i];
            }
            this.transactionDetails[trans.length] = addtransactions;
        }
        else {
            this.transactionDetails[0] = addtransactions;
        }

        System.out.println("added to transactions"+transactionDetails.length);
//        showTransactionDetailsAll();
    }

}