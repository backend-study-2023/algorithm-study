package zezeg2.stack_queue.올바른괄호;

import java.util.Stack;

public class Solution {
    boolean solution(String s) {
        if (s.charAt(0) == '(' && s.charAt(s.length() - 1) == ')') {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') stack.push(c);
                else {
                    if (stack.empty()) return false;
                    stack.pop();
                }
            }
            return stack.empty();
        }
        return false;
    }
}
