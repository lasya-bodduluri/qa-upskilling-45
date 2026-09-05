package Day02;

public class TipSplitter {
    public static void main(String[] args){
        double bill = 1000;
        double tipPercent = 10;
        double tipAmount;
        double totalBill;
        int people = 4;
        double amountPerPerson;
        tipAmount = bill*tipPercent/100;
        totalBill = bill+tipAmount;
        amountPerPerson = totalBill/people;
        System.out.println("Tip Amount: " + tipAmount);
        System.out.println("Total Bill: " + totalBill);
        System.out.println("Amount Per Person: " + amountPerPerson);
    }
}
