package zezeg2.stack_queue.주식가격;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Solution {
    public static int[] solution(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        Arrays.stream(prices).forEach(stack::add);
        List<Integer> priceSequence = Arrays.stream(prices).boxed().collect(Collectors.toList());
        AtomicInteger count = new AtomicInteger();
        final int length = prices.length;
        List<Integer> list = Arrays.stream(prices).map(price -> countUntilFindLower(stack.pop(), priceSequence.subList(length - 1 - count.getAndIncrement(), length - 1))).boxed().collect(Collectors.toList());
        Collections.reverse(list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int countUntilFindLower(int criteria, List<Integer> list) {
        int count = 0;
        for (Integer num : list) {
            if (num < criteria) return count;
            count++;
        }
        return count;
    }

    public static int[] correctSolution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer[]> stack = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            answer[i] = answer.length - 1 - i;
            Integer[] arr = {i, prices[i]};
            while (!stack.empty() && stack.peek()[1] > prices[i]) {
                Integer[] price = stack.pop();
                answer[price[0]] = i - price[0];
            }
            stack.push(arr);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        Arrays.stream(solution(prices)).forEach(System.out::println);
    }
}
