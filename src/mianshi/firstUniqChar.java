package mianshi;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-05-30 20:40
 */
public class firstUniqChar {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if(map.keySet().contains(arr[i])) {
                map.put(arr[i], -1);
            } else {
                map.put(arr[i], i);
            }
        }
        int ans = s.length();
        for (Character character : map.keySet()) {
            if(map.get(character) != -1)
            ans = Math.min(map.get(character), ans);
        }

        return ans == s.length() ? -1 : ans;
    }
}
