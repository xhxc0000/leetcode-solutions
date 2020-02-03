class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m < 1) return 0;

        int n = matrix[0].length;
        int res = 0;
        int[] height = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    height[j] += 1;
                } else {
                    height[j] = 0;
                }
            }
            res = Math.max(res, largestRectangleArea(height));
        }

        return res;
    }

    private int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        stack.push(-1);

        for (int i = 0; i < height.length; i++) {
            while (stack.peek() != -1 && height[stack.peek()] > height[i]) {
                res = Math.max(res, height[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }

        while (stack.peek() != -1) {
            res = Math.max(res, height[stack.pop()] * (height.length - stack.peek() - 1));
        }

        return res;
    } 
}
