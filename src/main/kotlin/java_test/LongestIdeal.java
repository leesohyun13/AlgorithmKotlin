package java_test;

/**
 * 2370. Longest Ideal Subsequence
 *
 * https://leetcode.com/problems/longest-ideal-subsequence/description/
 *
 * runtime 37ms (53.77%)
 * memory 45mb (21.70%)
 * */
public class LongestIdeal {
    public static void main(String[] args) {
        longestIdealString2("acfgbd", 2);
    }

    public static int longestIdealString2(String s, int k) {
        int res = 0, n = s.length(), dp[] = new int[26];

        for (int ci = 0; ci < n; ci++) {
            int i = s.charAt(ci) - 'a';
            System.out.println("-> i: " + i);
            for (int j = Math.max(0, i - k); j <= Math.min(25, i + k); j++) {
                dp[i] = Math.max(dp[i], dp[j]);
                System.out.println("res: " + res + " j: " + j + " dp[i]: " + dp[i] + " dp[j]: " + dp[j]);
            }
            System.out.println("res: " + res + " i: " + i + " dp[i]: " + dp[i]);
            res = Math.max(res, ++dp[i]);
        }

        return res;
    }
}
