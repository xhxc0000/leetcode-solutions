class Solution {
    public String largestNumber(int[] arr) {
       List<String> list = new ArrayList<>();
       for (int val : arr) list.add(String.valueOf(val));
       list.sort((o1, o2) -> (o2 + o1).compareTo(o1 + o2));
       StringBuilder res = new StringBuilder();
       for (String s : list) res.append(s);

       if (res.charAt(0) == '0') return "0";
       return res.toString();
    }
}
