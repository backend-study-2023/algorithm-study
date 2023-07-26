package Programmers.alweiis.stack_queue.올바른_괄호;

import java.util.Stack;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if ('(' == c) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}