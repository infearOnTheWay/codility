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
        int[] nextPeakIdx = new int[A.length];
        int nextPeak = -1;
        for (int i = A.length - 1; i != -1; i--) {
            if (i - 1 >= 0 && A[i] > A[i - 1] && i + 1 < A.length && A[i] > A[i + 1]) {
                peakIdx.add(0, i);
                nextPeak = i;
                nextPeakIdx[i] = i;
            } else {
                nextPeakIdx[i] = nextPeak;
            }
        }
        if (peakIdx.size() == 0) {
            return 0;
        }
        int last = 1, start = 1, end = peakIdx.size();
        while (start <= end) {
            int mid = (start + end) / 2;
            int cnt = 1, startPeakIdx = peakIdx.get(0);
            while (cnt < mid) {
                int pos = (startPeakIdx + mid >= nextPeakIdx.length ? -1 : nextPeakIdx[startPeakIdx + mid]);
                if (pos == -1) {
                    break;
                } else {
                    cnt++;
                    startPeakIdx = pos;
                }
            }
            if (cnt == mid) {
                last = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return last;
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
}
