public class BitMap {

    public static void main(String[] args) {

    }

        private byte[] bits;
    private int cap;

    public BitMap(int cap) {
        this.cap = cap;
        bits = new byte[cap / 8 + 1];
    }


    public void set(int k) {
        if (k > cap) return;
        int byteIndex = k / 8;
        int bitIndex = k % 8;
        bits[byteIndex] |= (1 << bitIndex);
    }

    public boolean get(int k) {
        if (k > cap) return false;
        int byteIndex = k / 8;
        int bitIndex = k % 8;

        return (bits[byteIndex] & (1 << bitIndex)) == 1;
    }


}
