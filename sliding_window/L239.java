class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        if (arr.length < 1) return new int[0];
        Deque<Integer> deq = new LinkedList<>();
        int cur = 0;
        int[] res = new int[arr.length - k + 1];
        int index = 0;
        while (cur < arr.length) {
            // 处理队列中过期数值
            if (!deq.isEmpty() && cur - deq.peekFirst() >= k) deq.pollFirst();
            // 维护单调性，入队
            while (!deq.isEmpty() && arr[deq.peekLast()] < arr[cur]) deq.pollLast();
            deq.offer(cur);

            // 添加答案
            if (cur + 1 >= k) {
                res[index++] = arr[deq.peekFirst()];
            }

            cur++;
        }

        return res;
    }
}
