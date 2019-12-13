import java.util.*;

public class J42_TrappingRainWater {
  public static void main(String[] args) {
    int[] arr = {3, 0, 0, 1, 0, 2, 0, 4};
    System.out.println(trap(arr));
  }


  // 单调递减栈, top 是U型区的低,i 是右边第一个高度大于top的值,
  // top - 1 是左边第一个高度大于 top的值
  // 维持单调性 -> h[top] <= h[i] 就出栈

  // 如何枚举?
  // 枚举U型区, 即对于每一条柱子, 找到左右两边第一个比它高的柱子
  // 如何快速找到? 单调递减栈, 左边peek, 当前 top, 右边 i,  W = (i - peek - 1), H = `min(h[i], h[peek])` - h[top]
  // 故 最终枚举每个U型区, 计算面积并相加
  // 注意边界判断
  public static int trap(int[] height) {
       int res = 0;
       Stack<Integer> stk = new Stack<>();

       // enumerate each bar
       for (int i = 0; i < height.length; i++) {
           while (!stk.isEmpty() && height[stk.peek()] < height[i]) {
               // 维护单调递减性
               int top = stk.pop();
               if (stk.isEmpty()) break;
               int W = i - stk.peek() - 1;
               int H = Math.min(height[i], height[stk.peek()]) - height[top];
               res += W * H;
           }
           stk.push(i);
       }

       return res;
   }
}
