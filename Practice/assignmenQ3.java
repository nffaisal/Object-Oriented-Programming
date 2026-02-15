import java.util.*;
public class assignmenQ3 {
     static class BankAccount{
        private String accountNumber;
        private String accountHolder;
        private double balance;
        
        public String getAccountNumber(){      //getter method to access AccountNumber
            return accountNumber;
        }
        public String getAccountHolder(){   //getter method to access Account Holder
            return accountHolder;
        }
        public void setAccountHolder(String accountHolder){       //Method to update account holder 
            this.accountHolder =accountHolder;
        }
        public void setAccountNumber(String accountNumber){       //Method to update account holder 
            this.accountNumber =accountNumber;
        }
        public void setBalance(double balance){     //Method to update balance
             if(balance> 0){                       //validation check for updating balance
                this.balance = balance;
             }
            }
        public void deposit(double amount){          //Method to deposit money into balance
            this.balance +=amount;
            System.out.print(" Successful ");
            System.out.print("Current Balance: " + balance );
        }
        public void withdraw(double amount){         //method to withfraw money from balance
            if(balance <=1200){
                System.out.println("failed - Insufficient Balance");
            }else{ //If  Balance less than 1200 no money withdrawn
               this.balance -= amount;
            }
            System.out.print("Current Balance: " + balance );
        }     
        }
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
           BankAccount Account = new BankAccount();   // make new object of account
        System.out.print("Enter Account holder name: ");
        String name = input.next();                 //user inputs name
        Account.setAccountHolder(name);          //settign account holder name using setter method
        System.out.print("Enter Account holder Number: ");
        String number = input.next();                      //user inputs account number
        Account.setAccountNumber(number);               //setting account number of user
        System.out.print("Enter Balance: ");     
        double balance = input.nextDouble();       //taking balance input from user
        Account.setBalance(balance);            //setting balance of user
        int option;       // otpion to chose to wihtdraw or deposit
        double amount;   //amoutn to withdraw or deposit
        do{
        System.out.println("\n--------1. Withdraw  2.Deposit  3.exit-------- ");
        option = input.nextInt();
        if(option ==1){
             System.out.println("Enter Amount:  ");
             amount =input.nextDouble();
              Account.withdraw(amount);       //withdrawal of amount
        }else if(option == 2){
             System.out.println("Enter Amount:  ");
             amount =input.nextDouble();
              Account.deposit(amount);  //depositing amount
        }else if(option ==3 ){
            break;               //breaks out of loop
        }
        
        }while(option != 3);
       input.close();
    }
}
