package java_test;


/**
 * 76. Minimum Window Substring
 *
 * https://leetcode.com/problems/minimum-window-substring/description
 *
 * one of the problems of Sliding Window
 */
public class MinWindow {
    public static void main(String[] args) {

    }

    /**
     * 1번쨰 구현 안
     * space 98%, memory 78%
     */
    public String solution1(String s, String t) {
        int [] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();
        while (end < s.length()) {
            final char c1 = s.charAt(end);
            if (map[c1] > 0) counter--;
            map[c1]--;
            end++;
            while (counter == 0) {
                if (minLen > end - start) {
                    minLen = end - start;
                    minStart = start;
                }
                final char c2 = s.charAt(start);
                map[c2]++;
                if (map[c2] > 0) counter++;
                start++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

    /**
     * 2번쨰 구현 안
     * space 100%, memory 38%
     */
    public String solution(String s, String t) {
        int m = s.length();
        int n = t.length();

        if (n == 0 || m < n) return "";
        if (m == n && s.equals(t)) return s;

        // english char은 int 0-127 범위 안의 숫자로 변환 가능
        int[] map = new int[128];
        int count = t.length();
        int start = 0, end = 0, minLen = Integer.MAX_VALUE, startIndex = 0;
        // t의 문자의 index의 문자 수를 카운트한다.
        for (char c : t.toCharArray()) {
            map[c]++;
        }

        char[] chS = s.toCharArray();
        while (end < chS.length) {
            // 끝자리 position을 찾아서 계속 이동한다.
            if (map[chS[end++]]-- > 0) {
                count--;
            }

            // 끝자리를 찾으면 시작할 문자위치를 찾으려고 point를 계속 이동한다.
            while (count == 0) {
                // 가장 짧은 문자의 길이를 계산한다.
                if (end - start < minLen) {
                    startIndex = start;
                    minLen = end - start;
                }
                if (map[chS[start++]]++ == 0) {
                    count++;
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? "" :
                new String(chS, startIndex, minLen);
    }
}
