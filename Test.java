import java.util.*;
public class Test {
  public static void main(String[] args) {
    Map<Character, Integer> map = new HashMap<>();
    map.put('c', 1);
    Integer v = map.get('c');
    v++;
    System.out.println(map.get('c'));
  }
}
