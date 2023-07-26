package Programmers.alweiis.stack_queue.주식가격;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int[] solution(int[] prices) {
        Queue<Integer> queue = new LinkedList<>();
        for (int price: prices) {
            queue.add(price);
        }

        int length = prices.length;
        int[] answer = new int[length];
        int p = 0;
        while (!queue.isEmpty()) {
            int price = queue.poll();
            for (int i = p + 1; i < length; i++) {
                answer[p]++;
                if (price > prices[i]) {
                    break;
                }
            }
            p++;
        }
        return answer;
    }
}
