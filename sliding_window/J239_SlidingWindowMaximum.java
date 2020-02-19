import java.util.*;
public class J239_SlidingWindowMaximum {
  public static void main(String[] args) {
    int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
    int k = 3;
    int[] res = maxSlidingWindow(arr, k);
    for (int val : res) System.out.print(val + " ");
    System.out.println();
  }


  // 暴力法, 枚举每个窗口内的最大值 - > N * K
  // 单调递减队列 , 队头最大, 队尾最小
  // 如何维护?
  // 每次移动窗口, 判断队首的值是否在窗口内, 如果不在则出队; 根据要入队的值来维护单调递减性

  // peekLast(), pollLast() 处理双端队列的队尾
  public static int[] maxSlidingWindow(int[] arr, int k) {
    LinkedList<Integer> queue = new LinkedList<>();
    int[] res = new int[arr.length - k + 1];
    for (int i = 0; i < arr.length; i++) {
      // remove invalid peek
      if (!queue.isEmpty() && queue.peek() < i - k + 1) queue.poll();
      // maintain monotonicity
      while (!queue.isEmpty() && arr[i] >= arr[queue.peekLast()]) queue.pollLast();
      // add cur
      queue.offer(i);
      // maintance res
      if (i - k + 1 >= 0) res[i + 1 - k] = arr[queue.peek()];
    }

    return res;
  }
}
