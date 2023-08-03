import java.util.*;

class Solution {
    
    public static Queue<Integer> queue = new LinkedList<>();
    public static boolean[] visited;
    public static ArrayList<Integer>[] arr;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[n+1];
        arr = new ArrayList[n+1];
        
        for (int i = 0; i <= n ;i++) {
            arr[i] = new ArrayList<>();
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i != j && computers[i-1][j-1] != 0) {
                    arr[i].add(j);
                }
            }
        }
        
        for (int i = 1 ; i <= n; i++) {
            if (!visited[i]) {
                bfs(i);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void bfs(int now) {
        
        queue.offer(now);
        visited[now] = true;
        
        while(!queue.isEmpty()) {
            
            int node = queue.poll();
            for (int elem : arr[node]) {
                if(!visited[elem]) {
                    queue.offer(elem);
                    visited[elem] = true;
                }
            }   
        }
    }
}