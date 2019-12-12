import java.util.*;
public class J187_RepeatedDNASeq {
  public static void main(String[] args) {
    String s = "AAAAAAAAAAA";
    List<String> res = findRepeatedDnaSequences(s);
    for (String val : res) System.out.println(val);
  }

  public static List<String> findRepeatedDnaSequences(String s) {
    List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 9; i < s.length(); i++) {
            String sub = s.substring(i - 9, i + 1);
            if (map.containsKey(sub)) {
                int val = map.get(sub);
                map.put(sub, ++val);
                if (val == 2) res.add(sub);
            }
            else map.put(sub, 1);
        }
        return res;
  }
}
