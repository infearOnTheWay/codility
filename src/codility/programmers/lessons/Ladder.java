package codility.programmers.lessons;

import java.math.BigInteger;

/**
 * https://app.codility.com/programmers/lessons/13-fibonacci_numbers/ladder/
 *
 * @author infearOnTheWay
 */
public class Ladder {
    public int[] solution(int[] A, int[] B) {
        // write your code in Java SE 8
        int l = A.length;
        if (l <= 1) {
            return new int[] {1};
        }
        BigInteger fibonacci[] = new BigInteger[l + 1];
        fibonacci[0] = fibonacci[1] = BigInteger.ONE;
        for (int i = 2; i <= l; i++) {
            fibonacci[i] = fibonacci[i - 1].add(fibonacci[i - 2]);
        }
        int re[] = new int[l];
        for (int i = 0; i != l; i++) {
            int mod = B[i];
            long base = 1L;
            while (mod != 0) {
                mod--;
                base *= 2L;
            }
            re[i] = fibonacci[A[i]].mod(BigInteger.valueOf(base)).intValue();
        }
        return re;
    }
}
