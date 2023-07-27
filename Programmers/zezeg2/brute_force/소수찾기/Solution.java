package zezeg2.brute_force.소수찾기;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    public static int solution(String numbers) {
        int answer = 0;
        Map<String, Integer> numMap = new HashMap<>();
        Arrays.stream(numbers.split("")).forEach(s -> {
            if (!numMap.containsKey(s)) numMap.put(s, 0);
            numMap.put(s, numMap.get(s) + 1);
        });

        int maxNumber = Integer.parseInt(numbers.chars().mapToObj(Character::getNumericValue).sorted((a, b) -> Integer.compare(b, a)).map(Object::toString).collect(Collectors.joining()));
        boolean[] primitiveArr = new boolean[maxNumber + 1];
        boolean[] checkArr = new boolean[maxNumber + 1];
        loop:
        for (int i = 2; i <= maxNumber; i++) {
            if (!checkArr[i]) primitiveArr[i] = true;
            for (int j = 1; i * j <= maxNumber; j++) checkArr[i * j] = true;
            if (primitiveArr[i]) {
                HashMap<String, Integer> copyMap = new HashMap<>(numMap);
                for (String s : String.valueOf(i).split("")) {
                    if (copyMap.containsKey(s)) {
                        Integer remain = copyMap.get(s);
                        if (remain == 1) copyMap.remove(s);
                        else copyMap.put(s, remain - 1);
                    } else continue loop;
                }
                answer++;
            }
        }
        return answer;
    }
}
