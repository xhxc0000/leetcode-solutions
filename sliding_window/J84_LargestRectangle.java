import java.util.*;
public class J84_LargestRectangle {
  public static void main(String[] args) {
    int[] arr = {6, 7, 5, 2, 4, 5 ,9, 3 };
    System.out.println(largestRectangleArea(arr));
  }

  public static int largestRectangleArea(int[] heights) {
    int res = 0;
    Stack<Integer> stk = new Stack<>();
    stk.push(-1);
    for (int i = 0; i < heights.length; i++) {
      while (stk.peek() != -1 && heights[stk.peek()] > heights[i]) {
        res = Math.max(res, heights[stk.pop()] * (i - stk.peek() - 1));
      }
      stk.push(i);
    }

    // 手动弹栈 top 右边不会有比小的元素, 故(rop - 1, length - 1]
    while (stk.peek() != -1) {
      res = Math.max(res, heights[stk.pop()] * (heights.length - stk.peek() - 1));
    }

    return res;
  }
}
