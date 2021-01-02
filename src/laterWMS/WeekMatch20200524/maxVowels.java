package laterWMS.WeekMatch20200524;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-05-24 10:37
 */
public class maxVowels {

    public int maxVowels(String s, int k) {
        if(s == null || "".equals(s)) return 0;
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        char[] arr = s.toCharArray();

        int ans = 0;
        for (int i = 0; i < k && i < s.length(); i++) {
            if(set.contains(arr[i])) ans+= 1;
        }
        if(k >= s.length()) return ans;

        int left = 0;
        int right = k;
        int count = ans;
        while (right < s.length()) {
            if(set.contains(arr[left])) count -= 1;
            if(set.contains(arr[right])) count += 1;
            ans = Math.max(ans, count);
            left ++;
            right ++;
        }

        return ans;

    }
}
