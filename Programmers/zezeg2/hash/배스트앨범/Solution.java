package zezeg2.hash.배스트앨범;

import java.util.*;
import java.util.stream.IntStream;

public class Solution {
    static class Song implements Comparable<Song> {
        int number, playCount;

        @Override
        public int compareTo(Song other) {
            return this.playCount != other.playCount ? other.playCount - this.playCount
                    : this.number - other.number;
        }

        public Song(int number, int playCount) {
            this.number = number;
            this.playCount = playCount;
        }
    }

    public static int[] solution(String[] genres, int[] plays) {
        final Map<String, PriorityQueue<Song>> m1 = new HashMap<>();
        Map<String, Integer> m2 = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            if (!m1.containsKey(genres[i])) {
                m1.put(genres[i], new PriorityQueue<>());
                m2.put(genres[i], 0);
            }
            m1.get(genres[i]).add(new Song(i, plays[i]));
            m2.put(genres[i], m2.get(genres[i]) + plays[i]);
        }
        var entries = new ArrayList<>(m2.entrySet());
        entries.sort((s1, s2) -> s2.getValue().compareTo(s1.getValue()));
        List<Integer> ansList = new ArrayList<>();
        entries.forEach(e -> {
            PriorityQueue<Song> songs = m1.get(e.getKey());
            IntStream.rangeClosed(1, 2).forEach(ignore -> {
                if (songs.iterator().hasNext()) ansList.add(songs.poll().number);
            });
        });
        return ansList.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop", "classic"};
        int[] plays = {500, 600, 150, 800, 2700, 800};
        Arrays.stream(solution(genres, plays)).forEach(System.out::println);
    }
}
