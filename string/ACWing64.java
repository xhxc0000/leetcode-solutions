class Solution {    
    
    private char[] hash = new char[256];
    private LinkedList<Character> queue = new LinkedList<>();
    
    //Insert one char from stringstream   
    public void insert(char ch){
        hash[ch]++;
        queue.offer(ch);
    }
    //return the first appearence once char in current stringstream
    public char firstAppearingOnce(){
        while (!queue.isEmpty() && hash[queue.peek()] > 1) {
            // hash[queue.peek()]--;
            queue.poll();
        }
        
        if (queue.isEmpty()) return '#';
        else return queue.peek();
    }
}

