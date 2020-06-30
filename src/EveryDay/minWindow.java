package EveryDay;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-06-27 19:11
 */
public class minWindow {

    public static void main(String[] args) {
        minWindow minWindow = new minWindow();
        minWindow.minWindow("AB","A");

    }

    public String minWindow(String s, String t) {
        if(s.equals(t)) return s;
        Set<Character> set = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();
        int windowCount = 1;
        int left = 0, right = 0;
        String ans = "";


        //初始化map、set
        for (int i = 0; i < t.length(); i++) {
            if(set.contains(t.charAt(i))) {
                map.put(t.charAt(i), map.get(t.charAt(i)) + 1);
            } else {
                set.add(t.charAt(i));
                map.put(t.charAt(i), 1);
            }
        }

        while (!set.contains(s.charAt(left))) left++;
        map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
        right = left + 1;


        while(right < s.length()) {
            if (set.contains(s.charAt(right))) {
                if(map.get(s.charAt(right)) > 0)
                    windowCount ++;
                map.put(s.charAt(right), map.get(s.charAt(right)) - 1);

            }
            right ++;

            if(windowCount == t.length()) {
                ans = right - left >= ans .length() && !"".equals(ans) ? ans :s.substring(left, right);
                while (true) {
                    if(!set.contains(s.charAt(left))) {
                        left++;
                        continue;
                    }
                    if(map.get(s.charAt(left)) >= 0) {
                        ans = right - left >= ans .length() && !"".equals(ans) ? ans :s.substring(left, right);
                        map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                        left ++;
                        while (left < s.length() && !set.contains(s.charAt(left))) left++;
                        windowCount--;
                        break;
                    } else {
                        map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                        left ++;
                    }

                }
            }
        }


        return ans;
    }

}
