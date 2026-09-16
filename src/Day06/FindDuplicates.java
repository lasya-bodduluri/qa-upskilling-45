package Day06;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicates {

    public static void main(String[] args){
        int[] numbers = {10, 20, 30, 20, 40, 10};
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i <numbers.length ; i++) {
        int number = numbers[i];
        if(seen.contains(number)){
        System.out.println(number);
        }
        else {
        seen.add(number);
        }
        }
    }
}
