package zezeg2.brute_force.전력망둘로나누기;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    private static List<List<Integer>> graph;
    private static boolean[] visited;

    public static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>(Collections.singletonList(start));
        visited[start] = true;

        int count = 0;
        while (!queue.isEmpty()) {
            int node = queue.remove();
            count++;

            graph.get(node).stream().filter(v -> !visited[v]).forEach(v -> {
                visited[v] = true;
                queue.add(v);
            });
        }

        return count;
    }

    public static int solution(int n, int[][] wires) {
        graph = Stream.generate(ArrayList<Integer>::new).limit(n + 1).collect(Collectors.toList());

        for (int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }

        return Arrays.stream(wires).mapToInt(wire -> {
            visited = new boolean[n + 1];
            visited[wire[1]] = true;

            int result = bfs(wire[0]);
            return Math.abs(result - (n - result));
        }).min().orElse(Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        int[][] ints = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
        System.out.println(solution(9, ints));
    }
}