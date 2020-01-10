class Solution {
    public List<Integer> getLeastNumbers_Solution(int [] arr, int k) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        
        for (int val : arr) {
            if (heap.size() < k) {
                heap.offer(val);
            } else if (!heap.isEmpty() && heap.peek() > val) {
                heap.poll();
                heap.offer(val);
            } 
        }
        
        int[] tmp = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            tmp[i] = heap.poll();
        }
        
        for (int val : tmp) res.add(val);
        
        return res;
    }
}
