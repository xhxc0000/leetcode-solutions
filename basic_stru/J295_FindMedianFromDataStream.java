import java.util.*;

public class J295_FindMedianFromDataStream {

  static class MedianFinder {

    private PriorityQueue<Integer> big;   // down
    private PriorityQueue<Integer> small; // up


    public MedianFinder() {
      // jdk 默认小根堆
      small = new PriorityQueue<>();
      big = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
          return o2 - o1;
        }
      });
    }

    public void addNum(int num) {
      big.offer(num);
      if (!small.isEmpty() && small.peek() < big.peek()) {
        // case swap peek
        int b = big.poll(), s = small.poll();
        big.offer(s); small.offer(b);
      }
      if (big.size() - small.size() > 1) small.offer(big.poll());
    }

    public double findMedian() {
      if (big.size() - small.size() == 0) return (small.peek() + big.peek()) / 2.0;
      else return big.peek();
    }

  }


  public static void main(String[] args) {
    MedianFinder m = new MedianFinder();
    m.addNum(2);
    m.addNum(3);
    m.addNum(4);
    System.out.println(m.findMedian());
  }


}
