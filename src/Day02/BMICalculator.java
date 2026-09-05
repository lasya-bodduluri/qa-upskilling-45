package Day02;

public class BMICalculator {
    public static void main(String[] args){

        double weight=60.5;
        double height=1.65;
        double bmi;
        System.out.println(weight);
        System.out.println(height);

        bmi=weight/(height*height);
        //System.out.println("BMI is: " + bmi);
        System.out.printf("BMI is: %.2f%n", bmi);
    }
}
