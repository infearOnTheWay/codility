package codility.programmers.lessons;

/**
 * https://app.codility.com/programmers/lessons/14-binary_search_algorithm/min_max_division/
 *
 * @author infearOnTheWay
 */
public class MinMaxDivision {
    public int solution(int K, int M, int[] A) {
        int len = A.length;
        // sum[i] = A[0:i)
        int prefixSum[] = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            prefixSum[i] = prefixSum[i - 1] + A[i - 1];
        }
        // binary search [min,max]
        int sumUpper = Math.min(prefixSum[len], M * len), sumLower = 0, lastMinMax = sumUpper;
        while (sumLower <= sumUpper) {
            int sumMid = (sumLower + sumUpper) / 2;
            int canBePartitioned = isMinMaxDiv(sumMid, K, prefixSum);
            // 0-can be divided to K blocks 1-exist one block which sum is sumMid.
            if (canBePartitioned >= 0) {
                if (canBePartitioned == 1) {
                    lastMinMax = sumMid;
                }
                sumUpper = sumMid - 1;
            } else {
                sumLower = sumMid + 1;
            }
        }
        return lastMinMax;
    }

    private int isMinMaxDiv(int blockSum, int k, int[] prefixSum) {
        int re = -1, startIdx = 0;
        while (k != 0) {
            // find first idx make sum of A[startIdx,idx) <= blockSum
            int idx = findLastIndexSmallThan(startIdx, blockSum, prefixSum);
            if (idx == -1) {
                return -1;
            }
            // sum of A[startIdx,idx) exactly equal blockSum.
            if (prefixSum[idx] - prefixSum[startIdx] == blockSum) {
                re = 1;
            } else {
                if (re == -1) {
                    re = 0;
                }
            }
            k--;
            startIdx = idx;
        }
        // all elements should be arranged.
        if (startIdx != prefixSum.length - 1) {
            return -1;
        }
        return re;
    }

    // find last index make sum of A[startIdx, idx) <= blockSum
    private int findLastIndexSmallThan(int startIdx, int blockSum, int[] prefixSum) {
        int left = startIdx + 1, right = prefixSum.length - 1;
        int last = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (prefixSum[mid] - prefixSum[startIdx] > blockSum) {
                right = mid - 1;
            } else {
                last = mid;
                left = mid + 1;
            }
        }
        return last;
    }

    public static void main(String args[]) {
        int re = new MinMaxDivision().solution(3, 5, new int[] {2, 1, 5, 1, 2, 2, 2});
        System.out.println(re);
    }
}
