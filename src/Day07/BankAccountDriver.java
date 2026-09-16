package Day07;

public class BankAccountDriver {
    public static void main(String[] args) {

        BankAccount account = new BankAccount("ACC101","Lasya",1000);
        account.deposit(500);
        account.withdraw(300);
        System.out.println(account.getBalance());

        //for person class
        Person person = new Person("Lasya", 24);
        System.out.println(person.getName());
        System.out.println(person.getAge());
    }
}
