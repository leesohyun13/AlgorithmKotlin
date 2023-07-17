package java_test;

import java.util.HashMap;

/**
 * TotalFruit
 *
 * Runtime 51ms
 * Memory 54.09mb
 *
 * hashmap + sliding window
 *
 * https://leetcode.com/problems/fruit-into-baskets/description/
 * */
public class TotalFruit {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> data = new HashMap<>();
        int ans = 0;
        int start = 0;

        for (int i=0; i<fruits.length; i++) {
            data.put(fruits[i], data.getOrDefault(fruits[i], 0) + 1);

            while (data.size() > 2) {
                int item = fruits[start];
                int fruitsValue = data.getOrDefault(item, 0)-1;
                if (fruitsValue <= 0) {
                    data.remove(item);
                }
                if (fruitsValue > 0) {
                    data.put(item, fruitsValue);
                }
                start++;
            }

            ans = Math.max(i-start+1, ans);
        }

        return ans;
    }
}
