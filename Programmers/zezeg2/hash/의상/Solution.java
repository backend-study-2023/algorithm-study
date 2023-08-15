package zezeg2.hash.의상;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = getClothesPartCountMap(clothes);
        for (String s : map.keySet()) answer *= (map.get(s) + 1);
        return answer - 1;
    }

    private static Map<String, Integer> getClothesPartCountMap(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (String[] clothe : clothes) {
            if (map.containsKey(clothe[1])) {
                map.put(clothe[1], map.get(clothe[1]) + 1);
                continue;
            }
            map.put(clothe[1], 1);
        }
        return map;
    }
}
