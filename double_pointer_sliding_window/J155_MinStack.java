import java.util.*;
public class J155_MinStack {
   private static Stack<Integer> stack = new Stack<>();

   private static Stack<Integer> m = new Stack<>();

   /** initialize your data structure here. */
   public static MinStack() {

   }

   public static void push(int x) {
     stack.push(x);

     m.push(m.isEmpty() ? x : Math.min(m.peek(), x));
   }

   public static void pop() {
     stack.pop();
     m.pop();
   }

   public static int top() {
     return stack.peek();
   }

   public static int getMin() {
     return m.peek();
   }
}
