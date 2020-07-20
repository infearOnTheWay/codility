package codility.programmers.lessons;

import java.util.HashSet;

/**
 * https://app.codility.com/programmers/lessons/4-counting_elements/missing_integer/
 *
 * @author Zhang Gang (zhanggang02@baidu.com)
 */
public class SmallestPosInteger {
    public int solution(int[] A) {
        // write your code in Java SE 8
        HashSet<Integer> m = new HashSet<>();
        for (int ele : A) {
            m.add(ele);
        }
        int r = 1;
        while (m.contains(r)) {
            r++;
        }
        return r;
    }
}
