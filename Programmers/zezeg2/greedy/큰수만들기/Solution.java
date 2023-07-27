package zezeg2.greedy.큰수만들기;

import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    // 시간 초과
    public static String solution(String number, int k) {
        List<Integer> numList = number.chars().map(Character::getNumericValue).boxed().collect(Collectors.toList());
        for (int i = 0; i < numList.size() && k > 0; i++) {
            if (numList.get(i) < numList.get(Math.min(i + 1, numList.size() - 1))) {
                numList.remove(i);
                i = Math.max(-1, i - 2);
                k--;
            }
        }
        if (k != 0) numList = numList.subList(0, numList.size() - k);
        return numList.stream().map(String::valueOf).collect(Collectors.joining());
    }

    public static String solution2(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int length = number.length() - k;
        int start = 0;

        while (start < number.length() && answer.length() != length) {
            int leftLocation = k + answer.length() + 1;
            int max = 0;
            for (int j = start; j < leftLocation; j++) {
                if (max < number.charAt(j) - '0') {
                    max = number.charAt(j) - '0';
                    start = j + 1;
                }
            }
            answer.append(max);
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution2("4177252841", 4));
    }
}
