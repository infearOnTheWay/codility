/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package codility.programmers.lessons;

import java.util.LinkedList;
import java.util.List;

/**
 * https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/flags/
 *
 * @author Zhang Gang (zhanggang02@baidu.com)
 */
public class Flags {
    public int solution(int A[]) {
        // write your code in Java SE 8
        List<Integer> peakIdx = new LinkedList<>();
        for (int i = 0; i != A.length; i++) {
            if (i - 1 >= 0 && A[i] > A[i - 1] && i + 1 < A.length && A[i] > A[i + 1]) {
                peakIdx.add(i);
            }
        }
        if (peakIdx.size() == 0) {
            return 0;
        }
        int max = peakIdx.size();
        while (max != 1) {
            int idx = 1, startPeakIdx = 0;
            while (idx < max) {
                int pos = findFirstGreaterFrom(peakIdx, startPeakIdx, peakIdx.size() - 1,
                        peakIdx.get(startPeakIdx) + max);
                if (pos == -1) {
                    break;
                } else {
                    idx++;
                    startPeakIdx = pos;
                }
            }
            if (idx == max) {
                return max;
            }
            max--;
        }
        return max;
    }

    // start:inclusive, end:exclusive
    private int findFirstGreaterFrom(List<Integer> peakIdx, int start, int end, int base) {
        if (start == end) {
            if (peakIdx.get(start) >= base) {
                return start;
            }
            return -1;
        }
        int mid = (start + end) / 2;
        if (peakIdx.get(mid) >= base) {
            return findFirstGreaterFrom(peakIdx, start, mid, base);
        } else {
            return findFirstGreaterFrom(peakIdx, mid + 1, end, base);
        }
    }

    public static void main(String args[]) {
        new Flags().solution(new int[] {1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2});
    }
}
