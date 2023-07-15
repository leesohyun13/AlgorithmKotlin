package java_test;

import java.util.*;

/**
 * WordBreak
 *
 * https://leetcode.com/problems/word-break/description/
 *
 * recursion을 활용한 풀이
 * runtime 17ms (5.45%)
 * memory 41.86mb (73.48%)
 * */
public class WordBreak {
    public static void main(String[] args) {
        wordBreak("leetcodeleet", new ArrayList<String>(){{
            add("leet");
            add("code");
        }});
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        HashMap<String,Boolean> map= new HashMap<>();
        return dfs(s, words, map);
    }

    private static boolean dfs(String s, Set<String> words, Map<String, Boolean> map) {
        if (map.containsKey(s)) return map.get(s);
        if (s.isEmpty()) return true;
        System.out.println("[1] s: " + s);

        for (String word: words) {
            if (s.startsWith(word)) {
                System.out.println("[2] word: " + word);
                // and it is possible to construct the rest of the string
                // from the words in the dictionary
                if(dfs(s.substring(word.length()),words, map))
                {
                    System.out.println("[3] word: " + word);
                    // save and return true
                    map.put(s, true);
                    return true;
                }

            }
        }

        map.put(s, false);
        return false;
    }
}
