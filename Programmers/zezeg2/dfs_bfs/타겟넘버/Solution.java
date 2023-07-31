package zezeg2.dfs_bfs.타겟넘버;

public class Solution {
    static int answer = 0;

    static int solution(int[] numbers, int target) {
        int depth = 0;
        dfs(0, numbers, target, depth);
        return answer;
    }

    static void dfs(int prev, int[] numbers, int target, int depth) {
        if (depth == numbers.length && prev == target) answer++;
        else {
            dfs(prev + numbers[depth], numbers, target, depth + 1);
            dfs(prev - numbers[depth], numbers, target, depth + 1);
        }
    }
}