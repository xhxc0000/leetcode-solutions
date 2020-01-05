class Solution {
    public List<List<Integer> > findContinuousSequence(int sum) {
       List<List<Integer>> res = new ArrayList<>();
       
       for (int i = sum - 1; i > 0; i--) {
           List<Integer> path = new ArrayList<>();
           int s = i;
           for (int j = i - 1; j > 0; j--) {
               s += j;
               if (s == sum) {
                   while (j <= i) {
                       path.add(j);
                       j++;
                   }
                   res.add(path);
               } else if (s < sum) {
                   continue;
               } else {
                   // s > target
                   break;
               }
           }
       }
       
       
       return res;
    }

      // 双指针优化
      public List<List<Integer> > findContinuousSequence(int sum) {
        List<List<Integer>> res = new ArrayList<>();
        
        for (int i = 1, j = 1, s = 1; i < sum; i++) {
            while (s < sum) s += ++j;
            if (s == sum) {
                List<Integer> path = new ArrayList<>();
                for (int k = i; k <= j; k++) path.add(k);
                res.add(path);
            }
            
            s -= i;
        }
        
        return res;
    }
}
