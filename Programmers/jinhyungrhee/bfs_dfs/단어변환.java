import java.util.*;

class Solution {
    
    public class Node {
        String word;
        int stage;
        
        public Node(String word, int stage) {
            this.word = word;
            this.stage = stage;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        int N = words.length;
        boolean[] visited = new boolean[N];
    
        Queue<Node> q = new LinkedList<>();
        
        q.offer(new Node(begin, 0));
        //visited[0] = true;
        
        while(!q.isEmpty()) {
            
            Node now = q.poll();
            
            if (target.equals(now.word)) {
                //System.out.println(now.stage);
                //break;
                return now.stage;
            }
            
            for (int i = 0; i < N; i++) {
                if (compare(now.word, words[i]) && !visited[i]) {
                    q.offer(new Node(words[i], now.stage + 1));
                    visited[i] = true;
                }
            }
            
        }
        
        return answer;
    }
    
    public boolean compare(String first, String second) {
        int count = 0;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                count++;
            }
        }
        
        return count == 1 ? true : false;
        
    }
}