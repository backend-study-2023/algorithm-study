package programmers.카펫;

import java.util.Arrays;
import java.util.Collections;
public class Solution {
    private final int MIN_SIZE = 3;

    public static void main(String[] args) {

    }

    public static Integer[] solution(int brown, int yellow) {
        Integer[] answer = {};

        int vertical = 0;
        int width = 0;
        int numberOfBorders = 0;
        int tileTotal = brown + yellow;


        /**
         * 반복문에서 /3을 하는이뉴느 yellow 타일의 개수가 1개 늘어나면 brown타일은 2개
         * 총 타일은 3개가 늘어나기 때문임
         * i, j가 3x3인 경우 3x3을 말하며 가장 작은 단위의 타일임
         * 여기서 하나가 증가하면 3x4 또는 4x3이 됨
         * 타일이 총 늘어난 개수에서 3을 나눠야 한 단위가 증가한 것으로 볼 수 있음
         *
         * numberOfBorders = 4 + (i-2)*2 + (j-2)*2;
         * 모서리를 제외하고 중간의 노란부분을 제외하면 행은 행만
         * 열은 열만 계산하기 위한 계산식
         */
        Loop :
        for(int i = 3; i <= tileTotal/3; i++){
            for(int j = 3; j <= tileTotal/3; j++){
                if(i*j == tileTotal){
                    //모서리 4개 + (행-2)*2 + (열-2)*2
                    numberOfBorders = 4 + (i-2)*2 + (j-2)*2;
                    if(numberOfBorders == brown){
                        answer = new Integer[]{i, j};
                        break Loop;
                    }
                }
            }
        }

        Arrays.sort(answer, Collections.reverseOrder());
        return answer;
    }
}