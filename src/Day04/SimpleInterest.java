package Day04;

public class SimpleInterest {
    public static double calculateInterest(double principal,double rate, double time){
        double simpleInterest = (principal * rate * time) / 100;
        return simpleInterest;
    }

    public static void main(String[] args){
       double interest = calculateInterest(10000,5,2);
       System.out.println("Simple Interest: "+interest);
    }
}
