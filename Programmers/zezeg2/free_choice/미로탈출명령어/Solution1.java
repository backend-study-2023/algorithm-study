package zezeg2.free_choice.미로탈출명령어;

class Solution1 {
    static String UP = "u", DOWN = "d", LEFT = "l", RIGHT = "r";
    static int[] limitRange, targetPoint;
    static int targetLength;
    static StringBuilder found = null;

    public static String solution(int n, int m, int x, int y, int r, int c, int k) {
        limitRange = new int[]{n, m};
        targetPoint = new int[]{r, c};
        targetLength = k;
        dfs(new StringBuilder(), new int[]{x, y});
        if (found == null) return "impossible";
        return found.toString();
    }

    static boolean canMove(int[] current, String nextMove) {
        return switch (nextMove) {
            case "l" -> current[1] > 1;
            case "r" -> current[1] < limitRange[1];
            case "u" -> current[0] > 1;
            case "d" -> current[0] < limitRange[0];
            default -> throw new IllegalStateException("Unexpected value: " + nextMove);
        };
    }

    static boolean canReach(int[] current, StringBuilder route) {
        int diff = Math.abs(current[0] - targetPoint[0]) + Math.abs(current[1] - targetPoint[1]);
        return targetLength - route.length() >= diff && (targetLength - route.length()) % 2 == diff % 2;
    }

    static boolean isArrive(int[] current) {
        return current[0] == targetPoint[0] && current[1] == targetPoint[1];
    }

    static boolean dfs(StringBuilder route, int[] current) {
        if (route.length() == targetLength) {
            if (isArrive(current)) {
                found = route;
                return true;
            }
            return false;
        }
        for (var move : new String[]{DOWN, LEFT, RIGHT, UP}) {
            if (canMove(current, move)) {
                int[] next = move.equals(DOWN) ? new int[]{current[0] + 1, current[1]}
                        : move.equals(LEFT) ? new int[]{current[0], current[1] - 1}
                        : move.equals(RIGHT) ? new int[]{current[0], current[1] + 1}
                        : move.equals(UP) ? new int[]{current[0] - 1, current[1]} : new int[]{0, 0};
                route.append(move);
                if (canReach(next, route)) return dfs(route, next);
                else route.deleteCharAt(route.length() - 1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(solution(6, 6, 2, 6, 6, 5, 11));
    }
}
