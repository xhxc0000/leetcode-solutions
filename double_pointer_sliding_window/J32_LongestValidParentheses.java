import java.util.*;
public class J32_LongestValidParentheses {
  public static void main(String[] args) {
    String s = ")()())";
    // System.out.println(longestValidParentheses(s));
    System.out.println(stackRes(s));
  }

  // 双指针解法
  public static int longestValidParentheses(String s) {
    char[] arr = s.toCharArray();
    int res1 = longestValidParentheses(arr);
    reverse(arr);
    int res2 = longestValidParentheses(arr);
    return Math.max(res1, res2);
  }


  public static int stackRes(String s) {
    Stack<Integer> stack = new Stack<>();
    int res = 0;
    for (int i = 0, start = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        stack.push(i);
      } else {
        if (!stack.isEmpty()) {
          stack.pop();
          res = stack.isEmpty() ? Math.max(res, i - start + 1) : Math.max(res, i - stack.peek());
        } else {
          start = i + 1;
        }
      }
    }

    return res;
  }


  private static int longestValidParentheses(char[] arr) {
    int res = 0;
    for (int i = 0, start = 0, count = 0; i < arr.length; i++) {
      if (arr[i] == '(') {
        count++;
      } else {
        count--;
        if (count < 0) {
          start = i + 1; count = 0;
        } else if (count == 0) {
          res = Math.max(res, i - start + 1);
        }
      }
    }

    return res;
  }


  private static void reverse(char[] arr) {
    int L = 0, R = arr.length - 1;
    while (L < R) {
      char tmp = arr[L];
      arr[L++] = arr[R];
      arr[R--] = tmp;
    }
    // reverse '(' and ')'
    for (int i = 0; i < arr.length; i++) {
      arr[i] ^= 1;
    }
  }
}
