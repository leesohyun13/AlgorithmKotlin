package java_test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 290. WordPattern
 *
 * https://leetcode.com/problems/word-pattern/
 * */
public class WordPattern {
    /**
     * sketch
     *
     *  예외상황
     *  1. pattern은 다르지만 단어가 같은 경우
     *
     *  Runtime 1ms -> 61.85% / O(n)
     *  Memory 40.4mb -> 87.46% / O(n)
     * */

    public boolean wordPattern(String pattern, String s) {
        int length = pattern.length();
        String[] words = s.split(" ");

        if (length != words.length) return false;
        Set<Character> dicPattern = new HashSet<>();
        Map<String, Character> dic = new HashMap<>();

        for (int i = 0; i < length; i++) {
            if (!dic.getOrDefault(words[i], pattern.charAt(i)).equals(pattern.charAt(i))) {
                return false;
            }
            dicPattern.add(pattern.charAt(i));
            dic.put(words[i], pattern.charAt(i));
        }

        if (dic.size() != dicPattern.size()) return false;

        return true;
    }
}
