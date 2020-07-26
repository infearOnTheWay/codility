package codility.programmers.lessons;

/**
 * https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/
 *
 * @author infearOnTheWay
 */
public class OddOccurrencesInArray {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int ele = A[0];
        for (int i = 1; i < A.length; i++) {
            ele = ele ^ A[i];
        }
        return ele;
    }
}
