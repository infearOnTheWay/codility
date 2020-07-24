/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package codility.programmers.ms.test;

/**
 * https://app.codility.com/c/feedback/A6UWY5-BEB/
 *
 * @author Zhang Gang (zhanggang02@baidu.com)
 */
public class Task2 {
    public int solution(String S) {
        // write your code in Java SE 8
        char charArray[] = S.toCharArray();
        if (charArray.length == 0) {
            return 0;
        }
        int cnt = 0, re = 0;
        char flag = charArray[0];
        for (char c : charArray) {
            if (c == flag) {
                cnt++;
            } else {
                re += cnt / 3;
                flag = c;
                cnt = 1;
            }
        }
        re += cnt / 3;
        return re;
    }
}
