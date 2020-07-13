package test;

import java.util.HashMap;
import java.util.Map;

/*
 * 3.无重复字符的最长子串   （滑动窗口）
 */
public class Solution {
    public  static int longthOfLongestSubString(String s){
        //哈希Map
        Map<Character, Integer> m = new HashMap<>();

        //创建滑动窗口
        int left = 0;
        int right = 0;

        //创建标志位
        int max = 1;

//        System.out.println(s.charAt(2));
        m.put(s.charAt(0), 1);
        while (right < s.length() - 1) {
            right++;
            if(m.containsKey(s.charAt(right))) {
                left = left > m.get(s.charAt(right)) ? left : m.get(s.charAt(right));
            }
            m.put(s.charAt((right)), right + 1);
            if(max < right - left + 1) max = right - left + 1;
        }
        return max;
    }
    public static void main(String[] args){
        System.out.println(Solution.longthOfLongestSubString("abcdefghijkabcbb"));
    }
}
