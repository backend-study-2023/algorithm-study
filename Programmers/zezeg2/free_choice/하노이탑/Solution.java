package zezeg2.free_choice.하노이탑;

import java.util.ArrayList;

class Solution {
    ArrayList<int[]> seq;
    public int[][] solution(int n) {
        seq = new ArrayList<>();
        hanoi(n, 1, 3, 2);
        return seq.toArray(int[][]::new);
    }

    private void hanoi(int n, int from, int to, int via){
        int[] move = {from, to};

        if(n == 1) {
            seq.add(move);
        } else {
            hanoi(n - 1, from, via, to);
            seq.add(move);
            hanoi(n - 1, via, to, from);
        }
    }
}