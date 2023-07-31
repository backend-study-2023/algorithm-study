package zezeg2.dfs_bfs.네트워크;

public class Solution {
    static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++){
            if (!visited[i]){
                answer++;
                dfs(i, visited, computers);
            }
        }
        return answer;
    }

    static void dfs(int node, boolean[] visited, int[][] computers){
        visited[node] = true;
        for (int i = 0; i < computers.length; i++){
            if (computers[node][i] == 1 && !visited[i]) {
                dfs(i, visited, computers);
            }
        }
    }
}