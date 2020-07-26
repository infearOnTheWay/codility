package codility.programmers.lessons;

/**
 * https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/
 *
 * @author Zhang Gang (zhanggang02@baidu.com)
 */
public class CyclicRotation {
    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        if (A.length == 0) {
            return A;
        }
        int k = K % A.length;
        int left = A.length - k;
        for (int i = 0, j = left - 1; i < j; i++, j--) {
            swap(A, i, j);
        }
        for (int i = left, j = A.length - 1; i < j; i++, j--) {
            swap(A, i, j);
        }
        for (int i = 0, j = A.length - 1; i < j; i++, j--) {
            swap(A, i, j);
        }
        return A;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
