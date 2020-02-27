import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Counter {

    private static Set<String> set = new TreeSet<>(new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            o1 = o1.substring(1, o1.length() - 5);
            o2 = o2.substring(1, o2.length() - 5);

            return Integer.parseInt(o1) - Integer.parseInt(o2);
        }
    });

    public static void main(String[] args) throws FileNotFoundException {
        String abs = "/home/xhxc/git/leetcode-solutions";
        if (args.length > 1) abs = args[0];
        scanFiles(abs);

        int count = 1;
        for (String name : set) {
            if (count++ % 10 == 0) System.out.println();
            System.out.print(name + " ");
        }

        System.out.println();
        System.out.println();
        System.out.println("------------ absense ---------");
        count = 1;
        for (int i = 1; i < 200; i++) {
            String s = "L" + i + ".java";
            if (!set.contains(s)) {
                count++;
                if (count % 10 == 0) System.out.println();


                System.out.print(s + " ");
            }

        }

    }


    private static void scanFiles(String path) throws FileNotFoundException {
        File dir = new File(path);
        if (!dir.isDirectory()) {
            throw new FileNotFoundException("isn't a directory");
        }

        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                scanFiles(file.getAbsolutePath());
            }

            String name = file.getName();
            if (name.length() > 6 && name.startsWith("L") && name.charAt(1) >= '0' && name.charAt(1) <= '9') set.add(name);
        }
    }
}

