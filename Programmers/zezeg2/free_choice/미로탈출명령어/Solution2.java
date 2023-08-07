package zezeg2.free_choice.미로탈출명령어;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution2 {
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};

    static class Point {
        public int x, y;
        public StringBuilder route;

        public Point(int x, int y, StringBuilder route) {
            this.x = x;
            this.y = y;
            this.route = route;
        }
    }

    static char convertDir(int d) {
        if (d == 0) return 'd';
        if (d == 1) return 'l';
        if (d == 2) return 'r';
        if (d == 3) return 'u';
        return 'x';
    }

    public static String solution(int n, int m, int x, int y, int r, int c, int k) {
        boolean[][][] chk = new boolean[n + 1][m + 1][k + 1];
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(x, y, new StringBuilder()));
        chk[x][y][0] = true;

        while (!q.isEmpty()) {
            Point current = q.poll();
            if (current.route.length() == k) {
                if (current.x == r && current.y == c) return current.route.toString();
                continue;
            }

            for (int move = 0; move < 4; move++) {
                int nx = current.x + dx[move];
                int ny = current.y + dy[move];
                if (nx < 1 || ny < 1 || nx > n || ny > m || chk[nx][ny][current.route.length() + 1]) continue;
                chk[nx][ny][current.route.length() + 1] = true;
                q.add(new Point(nx, ny, new StringBuilder(current.route).append(convertDir(move))));
            }
        }
        return "impossible";
    }
    public static void main(String[] args) {
        System.out.println(solution(3, 4, 2, 3, 3, 1, 5));
    }
}
