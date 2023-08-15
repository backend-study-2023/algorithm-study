package zezeg2.free_choice.정수삼각형;

public class Solution {
    public static int solution_fail(int[][] triangle) {
        int answer = 0, l = triangle.length;
        return dp_fail(0, triangle.length - 1, triangle, 0);
    }
    static int dp_fail(int start, int end, int[][] triangle, int depth){
        if (start == end) return triangle[depth][start];
        return triangle[depth][start] + Math.max(dp_fail(start + 1, end, triangle, depth + 1), dp_fail(start, end - 1, triangle, depth + 1));
    }

    public static int solution(int[][] triangle) {
        return bottomUp(triangle[triangle.length - 1], triangle)[0];
    }

    static int[] bottomUp(int[] under, int[][] triangle){
        if (under.length == 1) return under;
        int[] upper = triangle[under.length - 2];
        int[] maximumArr = new int[upper.length];
        for (int i = 0; i < upper.length; i++) maximumArr[i] = upper[i] + Math.max(under[i], under[i + 1]);
        return bottomUp(maximumArr, triangle);
    }

    public static void main(String[] args) {
        int [][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(solution(triangle));
    }
}