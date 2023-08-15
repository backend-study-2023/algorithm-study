package zezeg2.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solutions {
    public static int solution1(String s, int N) {
        int answer = 0;
        for (int i = 0; i < s.length() - N; i++) {
            String sub = s.substring(i, i + N);
            if (Arrays.stream(sub.split("")).mapToInt(Integer::valueOf).anyMatch(n -> n > N) && Arrays.stream(sub.split("")).mapToInt(Integer::valueOf).distinct().count() != N)
                continue;
            answer = Math.max(answer, Integer.valueOf(sub));
        }
        return answer;
    }

    public static int recurse(int[][] relationships, int target, int prevTarget, int limit) {
        int answer = 0;
        if (limit == 0) return 0;
        List<int[]> list = Arrays.stream(relationships).filter(t -> Arrays.stream(t).anyMatch(e -> e == target) && Arrays.stream(t).noneMatch(e -> e == target || e == prevTarget)).collect(Collectors.toList());
        ;
        answer += list.size() - 1;
        for (int[] l : list) {
            answer += prevTarget == target ? 5 : 10;
            int newTarget = Arrays.stream(l).filter(value -> value != target).findAny().getAsInt();
            answer += recurse(relationships, newTarget, target, limit - 1);
        }
        return answer;
    }

    public static void main(String[] args) {
        String s = "1451232125";
        int N = 2;
        System.out.println(solution1(s, N));
    }
}
