package programmers.전력망을_둘로_나누기;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Solution {

    private static ArrayList<Integer>[] transmissionTowers;

    public static void main(String[] args) {

        int n = 9;
        int [][] wires = new int[][]{
                {1, 3}, {2, 3}, {3, 4}, {4, 5},
                {4, 6}, {4, 7}, {7, 8}, {7, 9}
        };

        System.out.println(solution(n, wires));
    }

    public static int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        //i는 0부터 시작이 아닌 1부터 시작이기 때문에 n+1을 해줌
        transmissionTowers = new ArrayList[n+1];

        IntStream.rangeClosed(1, n)
                .forEach(i -> transmissionTowers[i] = new ArrayList<>());

        IntStream.range(0, wires.length)
                .forEach(i -> {
                    int from = wires[i][0];
                    int to = wires[i][1];
                    transmissionTowers[from].add(to);
                    transmissionTowers[to].add(from);
                });

        for(int i = 0; i < wires.length; i++) {
            int from = wires[i][0];
            int to = wires[i][1];

            boolean[] visited = new boolean[n + 1];

            //해당 간선을 송전탑 리스트에서 제거
            transmissionTowers[from].remove(Integer.valueOf(to));
            transmissionTowers[to].remove(Integer.valueOf(from));

            int count = dfs(1, visited);

            //송전탑은 트리 형식으로 연결되어 있으므로 하나로 연결되어 있음
            // 하나의 연결을 끊으면 2 범위로 분리됨
            int diff = Math.abs(count - (n - count));
            answer = Math.min(answer, diff);

            //다시 간선 추가
            transmissionTowers[from].add(to);
            transmissionTowers[to].add(from);

        }
        return answer;
    }

    private static int dfs(int vertex, boolean[] visited) {

        visited[vertex] = true;
        int count = 1;

        count += transmissionTowers[vertex].stream()
                .filter(nextVertex -> !visited[nextVertex])
                .mapToInt(nextVertex -> dfs(nextVertex, visited))
                .sum();

        return count;
    }
}
