package codility.programmers.lessons;

/**
 * https://app.codility.com/programmers/lessons/5-prefix_sums/genomic_range_query/
 *
 * @author Zhang Gang (zhanggang02@baidu.com)
 */
public class GenomicRangeQuery {
    public int[] solution(String S, int[] P, int[] Q) {
        // write your code in Java SE 8
        int l = S.length();
        int a[] = new int[l + 1], c[] = new int[l + 1], g[] = new int[l + 1], t[] = new int[l + 1];
        for (int i = 1; i <= S.length(); i++) {
            char ch = S.charAt(i - 1);
            a[i] = (ch == 'A' ? a[i - 1] + 1 : a[i - 1]);
            c[i] = (ch == 'C' ? c[i - 1] + 1 : c[i - 1]);
            g[i] = (ch == 'G' ? g[i - 1] + 1 : g[i - 1]);
            t[i] = (ch == 'T' ? t[i - 1] + 1 : t[i - 1]);
        }
        int[] r = new int[P.length];
        for (int i = 0; i != P.length; i++) {
            int end = Q[i] + 1, start = P[i];
            if (a[end] - a[start] > 0) {
                r[i] = 1;
            } else if (c[end] - c[start] > 0) {
                r[i] = 2;
            } else if (g[end] - g[start] > 0) {
                r[i] = 3;
            } else if (t[end] - t[start] > 0) {
                r[i] = 4;
            }
        }
        return r;
    }

}
