package codility.programmers.lessons;

/**
 * https://app.codility.com/programmers/lessons/1-iterations/binary_gap/s
 *
 * @author Zhang Gang (zhanggang02@baidu.com)
 */
public class BinaryGap {
    public int solution(int N) {
        // write your code in Java SE 8
        String str = Integer.toBinaryString(N);
        int max = 0, cnt = 0;
        boolean startCount = false;
        for (char c : str.toCharArray()) {
            if (c == '1') {
                if (startCount) {
                    max = Math.max(max, cnt);
                    cnt = 0;
                } else {
                    startCount = true;
                }
            } else {
                cnt++;
            }
        }
        return max;
    }
}
