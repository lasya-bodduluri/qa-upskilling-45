package Day04;

public class BMICalculation_Method {

    public static double calculateBMI(double weight, double height){

        double bmi = weight / (height * height);
        return bmi;
    }

    public static void main(String[] args){
        double bmi=calculateBMI(60.5,1.65);
        System.out.println("BMI is: "+bmi);
    }
}
