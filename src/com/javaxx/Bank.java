package com.javaxx;

class Bank{
    String name;
    String branch;
    User[] users;
    Bank(String name,String branch){
        this.name = name;
        this.branch = branch;
    }
    Bank(String name,String branch,User[] users){
        this.name = name;
        this.branch = branch;
        this.users = users;
    }

    void registerClients(User user){
        users = new User[users==null?1:users.length+1];
        users[users.length-1] = user;
    }
    User validateClient(int acc_no,int pin){
        if(users==null){
            message("No Users to validate:");
            return null;
        }
        for(User u:users){
            if(u.bank_account==acc_no && u.pin==pin)
                return u;


        }
        return null;
    }
    void showAllUsers(){
        if(users==null){
            message("No Users");
            return;
        }
        for(User u:users){
            u.show_bank();
            System.out.println(u.name);
            System.out.println(u.bank_account);
            System.out.println("Amount: Rs."+u.amount);
            System.out.println("==================");

        }
    }



    void show_bank(){
        System.out.println("Bank Name: "+name);
        System.out.println("Branch: "+branch);
    }


    void message(String message){

        System.out.println(message);

    }


//    void addTransaction(TransactionDetails addtransactions){
//        TransactionDetails[] trans = transactionDetails;
//        transactionDetails = new TransactionDetails[trans==null?1:trans.length+1];
//        if(trans!=null){
//            for(int i = 0;i<trans.length;i++){
//                this.transactionDetails[i] = trans[i];
//            }
//        }
//        this.transactionDetails[trans.length] = addtransactions;
//        System.out.println("added to transactions"+transactionDetails.length);
////        showTransactionDetails(transcationDetails);
//    }


}