import java.util.*;
public class J929_UniqueEmails {
  public static void main(String[] args) {
    String[] emails = {"test.email+alex@leetcode.com","test.email.leet+alex@code.com"};
    System.out.println(numUniqueEmails(emails));
  }



  private static int numUniqueEmails(String[] emails) {
    Set<String> set = new HashSet<>();
    for (String email : emails) {
      StringBuilder sb = new StringBuilder();
      // get index of '@'
      int index = email.indexOf('@');
      sb.append(getHostname(email, index))
      .append(email.substring(index, email.length()));

      set.add(sb.toString());
      System.out.println("add " + sb.toString());
    }

    return set.size();
  }


  private static String getHostname(String email, int edge) {
    StringBuilder res = new StringBuilder();
    for (int i = 0; i < edge; i++) {
      if (email.charAt(i) == '.') {
        continue;
      } else if (email.charAt(i) == '+') {
        break;
      } else {
        res.append(email.charAt(i));
      }
    }

    return res.toString();
  }
}
