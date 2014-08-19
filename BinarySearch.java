import java.util.Arrays;

public class BinarySearch {
    private BinarySearch() {
    }

    public static int rank(int key, int[] a) {
        return rank(key, a, 0, a.length - 1);
    }

    public static int rank(int key, int[] a, int lo, int hi) {
        if(lo > hi)
            return -1;
        int mid = lo + (hi - lo) / 2;
        if(key < a[mid])
            return rank(key, a, lo, mid - 1);
        else if(key > a[mid])
            return rank(key, a, mid + 1, hi);
        else
            return mid;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] whitelist = in.readAllInts();
        Arrays.sort(whitelist);
        while(!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if(rank(key, whitelist) == -1)
                StdOut.println(key);
        }
    }
}
