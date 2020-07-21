/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package codility.programmers.lessons;

/**
 * https://app.codility.com/programmers/lessons/5-prefix_sums/min_avg_two_slice/
 *
 * @author Zhang Gang (zhanggang02@baidu.com)
 */
public class MinAvgTwoSlice {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int sum[] = new int[A.length + 1];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + A[i - 1];
        }
        double allMin = Double.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < A.length - 1; i++) {
            double min = Double.MAX_VALUE;
            // 最小的平均值一定出现在长度为2和3的slice中
            for (int j = i + 1; j <= Math.min(i + 3, A.length - 1); j++) {
                min = Math.min(min, (sum[j + 1] - sum[i]) / ((j - i + 1) * 1.0));
            }
            if (min < allMin) {
                allMin = min;
                minIndex = i;
            }
        }
        return minIndex;
    }
}
