package codility.programmers.lessons;

/**
 * https://app.codility.com/programmers/lessons/11-sieve_of_eratosthenes/count_semiprimes/
 *
 * @author infearOnTheWay
 */
public class CountSemiPrimes {
    public int[] solution(int N, int[] P, int[] Q) {
        int[] primes = new int[N + 1];
        // 1-prime,2-the small factor
        for (int i = 2; i <= N; i++) {
            if (primes[i] == 0) {
                primes[i] = 1;
                for (int j = i; j <= N / i; j++) {
                    primes[j * i] = i;
                }
            }
        }
        int semiPrimes[] = new int[N + 1];
        for (int i = 2; i <= N; i++) {
            // i is composite and i/primes[i] is prime
            if (primes[i] != 1 && primes[i / primes[i]] == 1) {
                semiPrimes[i] = semiPrimes[i - 1] + 1;
            } else {
                semiPrimes[i] = semiPrimes[i - 1];
            }
        }
        int re[] = new int[P.length];
        for (int i = 0; i != re.length; i++) {
            re[i] = semiPrimes[Q[i]] - semiPrimes[P[i] - 1];
        }
        return re;
    }

    public static void main(String args[]) {
        int[] re = new CountSemiPrimes().solution(26, new int[] {1, 4, 16}, new int[] {26, 10, 20});
        System.out.println();
    }
}
