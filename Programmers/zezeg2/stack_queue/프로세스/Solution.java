package zezeg2.stack_queue.프로세스;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {
    public static int solution(int[] priorities, int location) {
        AtomicInteger mark = new AtomicInteger();
        Queue<List<Integer>> queue = new LinkedList<>();
        Arrays.stream(priorities).mapToObj(p -> List.of(mark.getAndIncrement(), p)).forEach(queue::add);
        List<Integer> answerSeq = new ArrayList<>();
        Arrays.stream(priorities).boxed().sorted(Comparator.comparingInt(i -> -i)).forEach(p -> {
            while (!queue.isEmpty()) {
                List<Integer> poll = queue.poll();
                if (poll.get(1).equals(p)) {
                    answerSeq.add(poll.get(0));
                    break;
                }
                queue.add(poll);
            }
        });
        return answerSeq.indexOf(location) + 1;
    }
}
