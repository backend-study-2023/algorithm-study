import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> mystack = new Stack<>();
        
        mystack.push(s.charAt(0));
        
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                //if (mystack.peek() == '(') {
                if (!mystack.isEmpty() && mystack.peek() == '(') {
                    mystack.pop();
                } else {
                    mystack.push(s.charAt(i));
                }
            } else { // '('
                mystack.push(s.charAt(i));
            }
        }
        
        return mystack.isEmpty();
    }
}