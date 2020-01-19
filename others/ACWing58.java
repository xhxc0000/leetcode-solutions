class Solution {
    public String printMinNumber(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int val : arr) list.add(val);
        Collections.sort(list, new Comparator<Integer>() {
           
           public int compare(Integer o1, Integer o2) {
               String s1 = o1 + "" + o2;
               String s2 = o2 + "" + o1;
               
               return s1.compareTo(s2);
           } 
        });
        
        StringBuilder sb = new StringBuilder();
        for (int val : list) {
            sb.append(val);
        }
        
        return sb.toString();
    }
}
