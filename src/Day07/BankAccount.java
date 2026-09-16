package Day07;

public class BankAccount {

    private String accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(String accountNumber,String accountHolder, double balance){
        this.accountNumber=accountNumber;
        this.accountHolder=accountHolder;
        this.balance=balance;
    }

    public void deposit(double amount){
        balance=balance+amount;
    }

    public void withdraw(double amount){
        if (amount<=balance){
            balance=balance-amount;
            System.out.println("Balance is: "+balance);
        }
        else{
            System.out.println("Insufficient Balance");
        }
    }
    public double getBalance() {
        return balance;

    }
}