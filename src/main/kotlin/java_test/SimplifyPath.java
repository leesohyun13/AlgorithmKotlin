package java_test;

import java.util.ArrayList;
import java.util.List;

/**
 * 71. Simplify Path
 * https://leetcode.com/problems/simplify-path/description/
 *
 * 문제 푼 시간: 36분
 * runtime: 4ms (92.89%)
 * memory: 43.6MB (42.41%)
 *
 * TIME: O(path length)
 * Space: O(path length)
 * */
public class SimplifyPath {
    public String simplifyPath(String path) {
        List<String> list = new ArrayList<String>();
        String[] texts = path.split("/");

        for (int i=0; i < texts.length; i++) {
            String data = texts[i];
            // REMOVE BEFORE PATH WHEN WE GET ".." PATH
            if (list.size() > 0 && data.equals("..")) {
                list.remove(list.size()-1);
                continue;
            }

            // IGNORE "." AND ".." AND EMPTY SPACE
            if (!data.isEmpty() && !data.equals(".") && !data.equals("..")) {
                list.add(texts[i]);
            }

        }

        // MAKE PATH FORMAT
        StringBuilder answer = new StringBuilder("/");
        for (int k=0; k<list.size(); k++) {
            String text = list.get(k);
            answer.append(text);
            if (k != list.size()-1) answer.append("/");
        }

        return answer.toString();
    }
}
