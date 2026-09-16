package Day04;

public class TipSplitter {
    public static double calculateAmountPerPerson(double bill, double tipPercent, int people) {

        double tipAmount = bill * tipPercent / 100;
        double totalBill = bill + tipAmount;
        double amountPerPerson = totalBill / people;

        return amountPerPerson;
    }

    public static void main(String[] args) {

        double amountPerPerson = calculateAmountPerPerson(1000, 10, 4);

        System.out.println("Amount per person: " + amountPerPerson);
    }
}
