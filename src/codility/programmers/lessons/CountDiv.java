package codility.programmers.lessons;

/**
 * @author Zhang Gang (zhanggang02@baidu.com)
 */
public class CountDiv {
    public int solution(int A, int B, int K) {
        // write your code in Java SE 8
        int min = A / K;
        if (A % K != 0) {
            min++;
        }
        int max = B / K;
        return max - min + 1;
    }
}
