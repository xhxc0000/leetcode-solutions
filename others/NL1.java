public class NL1 {
    private static final int[] mask = new int[4];

    static {
        int tmp = 255;
        for (int i = 0; i < 4; i++) {
            mask[i] = tmp;
            tmp = tmp << 8;
        }
    }

    public static int ipToInt(String ip) {
        int res = 0;
        String[] str = ip.split("\\.");
        for (int i = 0; i < 4; i++) {
            int val = Integer.parseInt(str[i]);
            val = val << i * 8;
            res |= val;
        }

        return res;
    }

    public static String intToIp(int ip) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int val = ip & mask[i];
            val = val >>> i * 8;
            res.append(val).append(".");
        }

        res.deleteCharAt(res.length() - 1);

        return res.toString();
    }
}
