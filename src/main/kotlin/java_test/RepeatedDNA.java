package java_test;

import java.util.*;

/**
 * https://leetcode.com/problems/repeated-dna-sequences/description/
 *
 * */
class RepeatedDNA {
    // hashmap 사용해서 각 단어의 중복여부를 count, check한다.
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> answer = new ArrayList<>();

        Map<String, Integer> dic = new HashMap<String, Integer>();
        for (int i = 0; i < s.length()-9; i++) {
            dic.put(s.substring(i, i + 10), dic.getOrDefault(s.substring(i, i + 10), 0) + 1);
        }

        for(String key : dic.keySet()){
            if (dic.get(key) > 1) {
                answer.add(key);
            }
        }
        return answer;
    }

    // Best example
    // 본 것과 결과 hash 2가지로 만든다. -> 한번 이상이것은 바로 output에 담는다.
    // 장점: for문을 1번만 반복하면 된다.
    // 단점: hashset을 2개 사용해야 한다. 메모리 사용이 좀더 많다.
    class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            int L = 10;
            HashSet<String> seen = new HashSet<String>();
            HashSet<String> output = new HashSet<String>();
            for(int i = 0;i<=s.length() - L;i++){
                String value = s.substring(i,i+L);
                if(!seen.add(value)) output.add(value);
            }
            return new ArrayList<String>(output);
        }
    }
}