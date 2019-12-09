import java.util.*;
public class ITUtils {
  public static void iterate(List<List<Integer>> list) {
    for (List<Integer> ints : list) {
      for (int i : ints) {
        System.out.print(i + " ");
      }
      System.out.println();
    }
  }
}
