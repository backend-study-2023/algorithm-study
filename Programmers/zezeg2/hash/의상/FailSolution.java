package zezeg2.hash.의상;

import java.util.*;

public class FailSolution {
    public static int solution(String[][] clothes) {
        int ans = 0;
        Map<String, List<String>> map = new HashMap<>();
        Arrays.stream(clothes).forEach(c -> {
            String kind = c[1], name = c[0];
            if (!map.containsKey(kind)) map.put(kind, new ArrayList<>());
            map.get(kind).add(name);
        });
        List<String> kinds = new ArrayList<>();
        for (var entry : map.entrySet()) kinds.add(entry.getKey());
        List<List<String>> combinations = generateCombinations(kinds);
        for (var c : combinations) ans += c.stream().mapToInt(value -> map.get(value).size()).reduce(1, (a, b) -> a * b);
        return ans;
    }

    public static List<List<String>> generateCombinations(List<String> strings) {
        List<List<String>> subsets = new ArrayList<>();
        for (int i = 1; i < 1 << strings.size(); i++) {
            List<String> subset = new ArrayList<>();
            for (int j = 0; j < strings.size(); j++) if ((i & (1 << j)) != 0) subset.add(strings.get(j));
            subsets.add(subset);
        }
        return subsets;
    }

    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(clothes));
    }
}
