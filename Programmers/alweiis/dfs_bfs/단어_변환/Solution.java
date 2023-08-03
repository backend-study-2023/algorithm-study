package Programmers.alweiis.dfs_bfs.단어_변환;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static class Node {
        String word;
        int count;
        public Node(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

    public int solution(String begin, String target, String[] words) {
        int length = words.length;
        int answer = 0;
        Queue<Node> queue = new LinkedList<>();

        boolean[] visited = new boolean[length];
        queue.add(new Node(begin, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.word.equals(target)) {
                return current.count;
            }
            for (int i = 0; i < length; i++) {
                if (canChange(current.word, words[i]) && !visited[i]) {
                    visited[i] = true;
                    queue.add(new Node(words[i], current.count + 1));
                }
            }
        }
        return answer;
    }

    private boolean canChange(String start, String end) {
        int diffCount = 0;
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) != end.charAt(i)) {
                diffCount++;
            }
        }
        return diffCount == 1;
    }
}