package java_test;

/**
 * Interleaving String
 *
 * https://leetcode.com/problems/interleaving-string/
 *
 * Level: Medium
 * */
public class InterleavingString {
    /**
     * solution sketch
     *
     * 예외상황
     * 1) s1, s2 문자 일부가 비슷 한 경우,
     * 2) s1, s2 문자가 일부가 동일하여, s3에서 substring하는 시기가 같은 경우, 어떤 문자를 먼저 substring 해야하나?
     *
     * # 공부 dfs 해결 알고리즘
     * 1) recursion <-- 선택 (코드량이 좀더 적음. 그외의 둘다 로직은 동일)
     * 2) stack
     *
     * Runtime 1s 94.44%
     * Memory 42.10%
     * */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.isEmpty() && s2.isEmpty() && s3.isEmpty()) return true;
        if (s1.length() + s2.length() != s3.length()) return false;

        Boolean[][] memo = new Boolean[s1.length()][s2.length()];
        return dfs(s1, 0, s2, 0, s3, 0, memo);
    }

    private boolean dfs(String s1, int p1, String s2, int p2,
                        String target, int p3, Boolean[][] memo) {
        if (p1 == s1.length()) {
            return target.substring(p3).equals(s2.substring(p2));
        }
        if (p2 == s2.length()) {
            return target.substring(p3).equals(s1.substring(p1));
        }
        if (memo[p1][p2] != null) {
            return memo[p1][p2];
        }

        if (s1.charAt(p1) == target.charAt(p3) && dfs(s1, p1 + 1, s2, p2, target, p3 + 1, memo)
                || s2.charAt(p2) == target.charAt(p3) && dfs(s1, p1, s2, p2 + 1, target, p3 + 1, memo)) {
            memo[p1][p2] = true;
            return true;
        }

        memo[p1][p2] = false;
        return false;
    }
}
