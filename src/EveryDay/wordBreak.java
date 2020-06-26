package EveryDay;

import java.util.*;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-06-25 13:06
 */
public class wordBreak {
    public static void main(String[] args) {
        wordBreak w = new wordBreak();
        String[] arr = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
        List<String> list = new ArrayList<>();
        for (String s : arr) {
            list.add(s);
        }
        System.out.println(w.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", list));
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for(int j = 0; j < i; j++) {
                dp[i] = dp[j] && set.contains(s.substring(j, i));
                if(dp[i]) break;
            }
        }
        return dp[s.length()];
    }


    public boolean wordBreka2(String s, List<String> list) {

        Set<String> set = new HashSet<>(list);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 0; i < s.length(); i++) {
            if(!dp[i]) continue;
            for(int j = i + 1; j<= s.length(); j++) {
                if(dp[j]) continue;
                dp[j] = set.contains(s.substring(i, j));
            }
        }

        return dp[s.length()];
    }



}
