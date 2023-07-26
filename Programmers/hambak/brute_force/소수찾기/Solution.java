package programmers.소수찾기;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        String numbers1 = "17";
        System.out.println(solution(numbers1));
    }

    public static int solution(String numbers) {

        int answer = 0;

        List<Integer> numberCombinations = getCombinations(numbers);

        for (Integer numberCombination : numberCombinations) {
            if(isPrimeNumber(numberCombination)) answer++;
        }

        return answer;
    }

    /* 소수인지 판별하는 함수 */
    private static boolean isPrimeNumber(int number) {

        if (number <= 1) {
            return false;
        }

        for(int i = 2; i <= Math.sqrt(number); i++) {
            if(number % i == 0) return false;
        }

        return true;
    }

    public static List<Integer> getCombinations(String str) {
        Set<Integer> combinations = new HashSet<>();
        generateCombinations(str, "", combinations);
        return new ArrayList<>(combinations);
    }

    private static void generateCombinations(String str, String current, Set<Integer> combinations) {
        if (!current.isEmpty()) {
            combinations.add(Integer.parseInt(current));
        }

        for (int i = 0; i < str.length(); i++) {
            String remaining = str.substring(0, i) + str.substring(i + 1);
            generateCombinations(remaining, current + str.charAt(i), combinations);
        }
    }

}
