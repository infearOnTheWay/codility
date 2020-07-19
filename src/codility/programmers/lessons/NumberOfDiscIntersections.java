package codility.programmers.lessons;

import java.util.Arrays;

/**
 * https://app.codility.com/programmers/lessons/6-sorting/number_of_disc_intersections/
 *
 * @author Zhang Gang (zhanggang02@baidu.com)
 */
public class NumberOfDiscIntersections {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Pair[] pairs = new Pair[A.length];
        for (int i = 0; i != A.length; i++) {
            pairs[i] = new Pair((long) i - (long) (A[i]), (long) (i) + (long) (A[i]));
        }
        Arrays.sort(pairs, (o1, o2) -> {
            if (o1.start < o2.start) {
                return -1;
            }
            if (o1.start == o2.start) {
                return Long.compare(o1.end, o2.end);
            }
            return 1;
        });
        int max = 10000000, result = 0;
        for (int i = 0; i != A.length; i++) {
            int j = findFirstMax(i, pairs, i + 1, A.length - 1);
            result += j - i - 1;
        }
        if (result >= max) {
            result = -1;
        }
        return result;
    }

    private int findFirstMax(int i, Pair[] pairs, int s, int e) {
        if (s > e) {
            return e + 1;
        }
        int mid = (s + e) / 2;
        if (pairs[mid].start <= pairs[i].end) {
            return findFirstMax(i, pairs, mid + 1, e);
        } else {
            return findFirstMax(i, pairs, s, mid - 1);
        }
    }

    class Pair {
        long start;
        long end;

        public Pair(long start, long end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String args[]) {

    }

}
