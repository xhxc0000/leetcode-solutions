import java.util.*;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<String> q = new PriorityQueue<>((o1, o2) -> {
            int val = map.get(o1) - map.get(o2);
            return val != 0 ? val : o2.compareTo(o1);
        });

        for (String word : words) map.put(word, map.getOrDefault(word, 0) + 1);

        for (String s : map.keySet()) {
            q.offer(s);
            if (q.size() > k) q.poll();
        }

        LinkedList<String> res = new LinkedList<>();

        while (!q.isEmpty()) {
            res.addFirst(q.poll());
        }

        return res;
    }
}
