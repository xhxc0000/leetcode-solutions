import java.util.*;

public class J692_TopKFrequentWords {
  public static void main(String[] args) {
    String[] words = {"the", "day", "is", "the", "sunday", "the", "sunday", "is", "is"};
    List<String> res = topKFrequent(words, 4);
    for (String s : res) System.out.println(s);
  }


  public static List<String> topKFrequent(String[] words, int k) {
    Map<String, Integer> map = new HashMap<>();
    PriorityQueue<String> heap = new PriorityQueue<>(new Comparator<String>() {
         @Override
         public int compare(String o1, String o2) {
             int val = map.get(o1) - map.get(o2);
             return val == 0 ? o2.compareTo(o1) : val;
         }
       });

     for (String wd : words) map.put(wd, map.getOrDefault(wd, 0) + 1);

     for (String wd : map.keySet()) {
         heap.offer(wd);
         if (heap.size() > k) heap.poll();
     }

     String[] res = new String[k];
     for (int i = k - 1; i >= 0; i--) res[i] = heap.poll();

     return Arrays.asList(res);
  }
}
