/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package codility.programmers.lessons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * https://app.codility.com/programmers/lessons/5-prefix_sums/genomic_range_query/
 *
 * @author Zhang Gang (zhanggang02@baidu.com)
 */
public class GenomicRangeQuery {
    public int[] solution(String S, int[] P, int[] Q) {
        // write your code in Java SE 8
        List<Integer> a = new ArrayList<>(), c = new ArrayList<>(), g = new ArrayList<>(), t = new ArrayList<>();
        HashMap<Character, Integer> m = new HashMap<>();
        m.put('A', 1);
        m.put('C', 2);
        m.put('G', 3);
        m.put('T', 4);
        HashMap<Character, List<Integer>> pos = new HashMap();
        pos.put('A', new ArrayList());
        pos.put('C', new ArrayList<>());
        pos.put('G', new ArrayList());
        pos.put('T', new ArrayList());
        for (int i = 0; i != S.toCharArray().length; i++) {
            pos.get( S.charAt(i)).add(i);
        }
        int[] r = new int[P.length];
        for (int i = 0; i != P.length; i++) {
            for (Character key : Arrays.asList('A', 'C', 'G', 'T')) {
                if (find(P[i], Q[i], pos.get(key), 0, pos.get(key).size() - 1)) {
                    r[i] = m.get(key);
                    break;
                }
            }
        }
        return r;
    }

    private boolean find(int left, int right, List<Integer> pos, int s, int e) {
        if (s > e) {
            return false;
        }
        if (pos.get(s) > right || pos.get(e) < left) {
            return false;
        }
        int mid = (s + e) / 2;
        if (pos.get(mid) > right) {
            return find(left, right, pos, s, mid - 1);
        } else if (pos.get(mid) < left) {
            return find(left, right, pos, mid + 1, e);
        }
        return true;
    }
}
