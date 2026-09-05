package Day03;

public class PrimeChecker {
    public static void main(String[] args){
        int number = 9;
        boolean isPrime = true;
        for (int i = 2; i < number; i++) {

            if (number % i == 0){
                //System.out.println("Not Prime");
                isPrime = false;
                break;
            }
        }
        if (isPrime) {
            System.out.println("Prime");
        } else {
            System.out.println("Not Prime");
        }
    }
}
