package zezeg2.free_choice.카펫;

public class Solution {
    public  static int[] solution(int brown, int yellow) {
        int[] answer = {};
        int sum = (brown + 4) / 2;
        for(int h = sum / 2; h > 0; h--){
            int w = sum - h;
            if(w * h == brown + yellow) {
                answer =  new int[] {w, h};
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(10,2));
    }
}
