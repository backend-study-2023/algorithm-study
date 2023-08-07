package zezeg2.dfs_bfs.단어변환;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    static class Node {
        String value;
        int edge;

        public Node(String value, int edge) {
            this.value = value;
            this.edge = edge;
        }
    }

    public int solution(String begin, String target, String[] words) {
        int n = words.length, ans = 0;
        Queue<Node> q = new LinkedList<>();
        boolean[] visit = new boolean[n];
        q.add(new Node(begin, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.value.equals(target)) {
                ans = cur.edge;
                break;
            }

            for (int i = 0; i < n; i++) {
                if (!visit[i] && isNext(cur.value, words[i])) {
                    visit[i] = true;
                    q.add(new Node(words[i], cur.edge + 1));
                }
            }
        }
        return ans;
    }

    static boolean isNext(String current, String next) {
        int cnt = 0;
        for (int i = 0; i < next.length(); i++) {
            if (current.charAt(i) != next.charAt(i)) {
                if (++cnt > 1) return false;
            }
        }
        return true;
    }
}