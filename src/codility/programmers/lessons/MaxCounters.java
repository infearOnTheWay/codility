/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package codility.programmers.lessons;

/**
 * https://app.codility.com/programmers/lessons/4-counting_elements/max_counters/
 *
 * @author Zhang Gang (zhanggang02@baidu.com)
 */
public class MaxCounters {
    public int[] solution(int N, int[] A) {
        int arr[] = new int[N];
        int max = 0, effectiveMax = 0;
        for (int op : A) {
            if (op >= 1 && op <= N) {
                if (arr[op - 1] < effectiveMax) {
                    arr[op - 1] = effectiveMax;
                }
                arr[op - 1]++;
                max = Math.max(max, arr[op - 1]);
            } else {
                effectiveMax = max;
            }
        }
        for (int i = 0; i != N; i++) {
            if (arr[i] < effectiveMax) {
                arr[i] = effectiveMax;
            }
        }
        return arr;
    }
}
