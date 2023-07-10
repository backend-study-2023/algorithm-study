package zezeg2.greedy.조이스틱;

public class Solution {
    public static int solution(String name) {
        int rlCount = name.length() - 1;
        int udCount = 0;
        StringBuilder sb = new StringBuilder(name);
        String reverseName = sb.reverse().toString();
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == 'A') rlCount = Math.min(rlCount, 2 * (Math.max(i - 1, 0)) + name.substring(i + 1).replaceFirst("^A+", "").length());
            if (reverseName.charAt(i) == 'A') rlCount = Math.min(rlCount, 2 * i + Math.max(0, reverseName.substring(i + 1).replaceFirst("^A+", "").length() - 1));
            udCount += Math.min(Math.abs('A' - name.charAt(i)), Math.abs('Z' + 1 - name.charAt(i)));
        }
        return rlCount + udCount;
    }
}