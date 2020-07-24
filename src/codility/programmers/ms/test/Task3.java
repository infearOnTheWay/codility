/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package codility.programmers.ms.test;

import java.util.HashMap;

/**
 * https://app.codility.com/c/feedback/A6UWY5-BEB/
 *
 * @author Zhang Gang (zhanggang02@baidu.com)
 */
public class Task3 {
    public int solution(int[] A, int M) {
        // write your code in Java SE 8
        if (A.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> idxToCnt = new HashMap<>();
        idxToCnt.put(0, 1);
        int max = 1;
        for (int i = 1; i != A.length; i++) {
            boolean addToExist = false;
            for (int idx : idxToCnt.keySet()) {
                if (Math.abs(A[idx] - A[i]) % M == 0) {
                    addToExist = true;
                    int cnt = idxToCnt.get(idx) + 1;
                    idxToCnt.put(idx, cnt);
                    max = Math.max(max, cnt);
                    break;
                }
            }
            if (!addToExist) {
                idxToCnt.put(i, 1);
            }
        }
        return max;
    }
}
