package Day04;

public class TemperatureConverter {
    public static double convertToFahrenheit(double celsius){
        double fahrenheit = (celsius*9/5)+32;
        return fahrenheit;
    }

    public static void main(String[] args) {
        double Fahrenheit=convertToFahrenheit(25);
        System.out.println("Temperature in Fahrenheit: "+Fahrenheit);
    }
}
