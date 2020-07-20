package codility.programmers.lessons;

/**
 * https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_double_slice_sum/
 *
 * @author Zhang Gang (zhanggang02@baidu.com)
 */
public class MaxDoubleSliceSum {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int left[] = new int[A.length];
        for (int mid = 2; mid <= A.length - 2; mid++) {
            left[mid] = Math.max(left[mid - 1] + A[mid - 1], 0);
        }
        int[] right = new int[A.length];
        for (int mid = A.length - 3; mid >= 1; mid--) {
            right[mid] = Math.max(right[mid + 1] + A[mid + 1], 0);
        }
        int max = 0;
        for (int i = 0; i != A.length; i++) {
            max = Math.max(left[i] + right[i], max);
        }
        return max;
    }

}
