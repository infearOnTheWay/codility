package codility.programmers.lessons;

import java.util.LinkedList;
import java.util.List;

/**
 * https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/peaks/
 *
 * @author infearOnTheWay
 */
public class Peaks {
    public int solution(int[] A) {
        int l = A.length;
        if (l <= 2) {
            return 0;
        }
        List<Integer> blockCnts = new LinkedList();
        // First peak idx from each index from 0 to l-1.
        int leftFirstPeakIdx[] = new int[l];
        int peakIdx = -1;
        for (int i = l - 1; i >= 0; i--) {
            if (i + 1 < l && A[i] > A[i + 1] && i - 1 >= 0 && A[i] > A[i - 1]) {
                peakIdx = i;
            }
            leftFirstPeakIdx[i] = peakIdx;
            if (i <= l / 2 && i >= 1 && l % i == 0) {
                blockCnts.add(i);
            }
        }
        for (int blockCnt : blockCnts) {
            int blockLength = l / blockCnt;
            int blockNum = 0;
            while (blockNum != blockCnt) {
                // First peak idx is greater than current block right end.
                int firstIdx = leftFirstPeakIdx[blockNum * blockLength];
                if (firstIdx == -1 || firstIdx >= (blockNum + 1) * blockLength) {
                    break;
                }
                blockNum++;
            }
            if (blockNum == blockCnt) {
                return blockCnt;
            }
        }
        return 0;
    }

    public static void main(String args[]) {
        new Peaks().solution(new int[] {2, 2, 2});
    }
}
