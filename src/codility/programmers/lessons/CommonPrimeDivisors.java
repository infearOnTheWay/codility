package codility.programmers.lessons;

import java.util.HashSet;
import java.util.Set;

/**
 * https://app.codility.com/programmers/lessons/12-euclidean_algorithm/common_prime_divisors/
 *
 * @author infearOnTheWay
 */
public class CommonPrimeDivisors {
    public int solution(int[] A, int[] B) {
        // write your code in Java SE 8
        int re = 0;
        for (int i = 0; i != A.length; i++) {
            int min = Math.min(A[i], B[i]);
            int max = Math.max(A[i], B[i]);
            Set<Integer> primeDivisorA = findPrimeDivisors(min);
            int bDivisorCntInA = 0;
            for (int prime : primeDivisorA) {
                if (max % prime != 0) {
                    break;
                }
                while (max % prime == 0) {
                    max = max / prime;
                }
                bDivisorCntInA++;
            }
            if (bDivisorCntInA == primeDivisorA.size() && max == 1) {
                re++;
            }
        }
        return re;
    }

    public Set<Integer> findPrimeDivisors(int a) {
        int val = a;
        Set<Integer> set = new HashSet<>();
        int base = 2;
        while (val != 1) {
            if (val % base == 0) {
                val = val / base;
                set.add(base);
            } else {
                base++;
            }
        }
        return set;
    }

    public static void main(String args[]) {
        int re = new CommonPrimeDivisors().solution(new int[] {10}, new int[] {30});
        System.out.println(re);
    }
}
