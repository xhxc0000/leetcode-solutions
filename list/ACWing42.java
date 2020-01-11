class Solution {
    public boolean isPopOrder(int[] push, int[] pop) {
        if (push.length < 1 && pop.length < 1) return true;
        if (push.length != pop.length) return false;
        Stack<Integer> stack = new Stack<>();
        
        int i = 0, j = 0;
        while (j < push.length) {
            if (!stack.isEmpty() && stack.peek() == pop[j]) {
                j++;
                stack.pop();
            } else {
                if (i >= push.length) return false;
                stack.push(push[i++]);
            }
        }
        
        return j == push.length;
    }
}
