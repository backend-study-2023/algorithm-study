package zezeg2.free_choice.표현가능한이진트리;

public class Solution {
    boolean dfs(String number) {
        int mid = (number.length() - 1) / 2;
        char root = number.charAt(mid);
        String left = number.substring(0, mid);
        String right = number.substring(mid + 1);

        if (root == '0' && (left.charAt((left.length() - 1) / 2) == '1' || right.charAt((right.length() - 1) / 2) == '1')) {
            return false;
        }
        if (left.length() >= 3) return dfs(left) && dfs(right);
        return true;
    }

    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            StringBuilder binaryTree = new StringBuilder(Long.toBinaryString(numbers[i]));
            int j = 0;
            while ((int) Math.pow(2, j) - 1 < binaryTree.length()) {
                j++;
            }
            while ((int) Math.pow(2, j) - 1 != binaryTree.length()) {
                binaryTree.insert(0, "0");
            }
            if (dfs(binaryTree.toString())) answer[i] = 1;
        }
        return answer;
    }
}
