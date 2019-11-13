import java.util.*;
public class IsValid {
  public static void main(String[] args) {
    System.out.println(isValid(args[0]));
  }

  private static boolean isValid(String s) {
    if (s == null || s.length() < 1) return true;
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(' || c == '[' || c == '{') {
        stack.push(c);
      } else if (c == ')' && stack.peek() == '(') {
        stack.pop();
      } else if (c == ']' && stack.peek() == '[') {
        stack.pop();
      } else if (c == '}' && stack.peek() == '{') {
        stack.pop();
      } else {
        return false;
      }
    }

    return stack.isEmpty();
  }
}
