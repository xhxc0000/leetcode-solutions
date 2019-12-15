public class J352_DataStreamAsDisjointIntervals {
  public static void main(String[] args) {
    
  }



    static class SummaryRange {

        private TreeMap<Integer, Integer> mapLR = new TreeMap<>(); // l -> r
        private TreeMap<Integer, Integer> mapRL = new TreeMap<>(); // r -> l


        public SummaryRange() {}


        public void addNum(int val) {
            if (existKey(val)) {
                return;
            } else {
                // get [,val - 1] and [val + 1, ]
                Integer leftL = mapRL.get(val - 1), rightR = mapLR.get(val + 1);
                if (leftL != null && rightR != null) {
                    // case merge both sides
                    int L = leftL, R = rightR;
                    mapRL.remove(val - 1); mapLR.remove(val + 1);
                    mapLR.put(L, R); mapRL.put(R, L);
                } else if (leftL != null) {
                    // case merge
                    int L = leftL, R = val;
                    mapRL.remove(val - 1);
                    mapLR.put(L, R); mapRL.put(R, L);
                } else if (rightR != null) {
                    // case merge right
                    int L = val, R = rightR;
                    mapLR.remove(val + 1);
                    mapRL.put(R, L); mapLR.put(L, R);
                } else {
                    // no merge
                    mapLR.put(val, val); mapRL.put(val, val);
                }
            }

        }

        public int[][] getIntervals() {
            int[][] res = new int[mapLR.size()][2];
            int i = 0;
            for (Map.Entry<Integer, Integer> entity: mapLR.entrySet()) {
                res[i][0] = entity.getKey();
                res[i++][1] = entity.getValue();
            }

            return res;
        }

        // lowerKey
        private boolean existKey(int key) {
            if (mapLR.containsKey(key) || mapRL.containsKey(key)) return true;
            Map.Entry<Integer, Integer> lower = mapLR.lowerEntry(key);
            if (lower == null) return false;

            return lower.getValue() >= key;
        }
    }
}
