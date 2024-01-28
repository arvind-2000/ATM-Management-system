package com.javaxx;

import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner choose = new Scanner(System.in);
        boolean checkloop = true;
        Bank banks = new Bank("SBI","Secretariat");

        User[] user = {
                new User("Takumi",4673,2456,465.70,banks),
                new User("Gojo",4672,2451,465.70,banks),
                new User("Nanami",4671,2452,465.70,banks),
                new User("Mikasa",4670,2456,465.70,banks),
                new User("kunitsu",4669,2456,465.70,banks),
                new User("Jiraiya",4668,2456,465.70,banks),
                new User("Kusina",4667,2456,465.70,banks),
                new User("Itachi",4666,2456,465.70,banks)

        };

        banks = new Bank(banks.name,banks.branch,user);
        Atm atm = new Atm("SBI Moirangkhom",0123,banks);
        TransactionDetails transactionDetails = new TransactionDetails(atm);
//        atm.showAllUsers();
//        //check validation
//        atm.setUser("4673","2456");
//        atm.user.showUserDetails();
        //Add transactions
        do{

            transactionDetails.show_bank();
            System.out.println("Choose Options: ");
            System.out.println("1 Atm Functions: ");
            System.out.println("0 Exit: ");

            switch (choose.nextInt()){
                case 1:
                    System.out.println("Enter acc No.: ");
                    int acc_no = choose.nextInt();
                    System.out.println("Enter Pin.: ");
                    int pin = choose.nextInt();
                    if(!transactionDetails.setUser(acc_no,pin))
                        break;
                    int x = 0;
                    while (x!=6) {
                        transactionDetails.showOptions();
                        x = choose.nextInt();
                        transactionDetails.doTransactions(x);
                        if(x>0 &&x<6)
                            transactionDetails.addTransaction(new TransactionDetails(transactionDetails.date,transactionDetails.description,transactionDetails));
                    }
                    break;
                case 0:
                    transactionDetails.message("XX Session Finished XX");
                    checkloop = false;
                    break;
                default:
                    transactionDetails.message("Your opinion is not important.Choose from ours >>>");
            }

        }while (checkloop);

        System.out.println("===== Exited =====");


    }
}












