package Day04;

public class AgeInDays {
    public static int calculateAgeInDays(int age) {
        int days = age * 365;
        return days;
    }

    public static void main(String[] args){
        int ageinDays= calculateAgeInDays(24);
        System.out.println(ageinDays);
    }
}
