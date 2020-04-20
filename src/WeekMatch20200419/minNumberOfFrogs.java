package WeekMatch20200419;


import java.util.HashMap;
import java.util.Map;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-04-19 11:25
 */
public class minNumberOfFrogs {

    public int minNumberOfFrogs(String croakOfFrogs) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('r', 0);
        map.put('o', 0);
        map.put('a', 0);
        map.put('k', 0);

        int now = 0;


        int ans = 0;
        char[] arr = croakOfFrogs.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 'c') {
                now += 1;
                ans = Math.max(now, ans);
                map.put('r', map.get('r') + 1);
            }
            else if(arr[i] == 'r') {
                if(map.get('r') == 0) return -1;
                map.put('r', map.get('r') - 1);
                map.put('o', map.get('o') + 1);
            } else if(arr[i] == 'o') {
                if(map.get('o') == 0) return -1;
                map.put('o', map.get('o') - 1);
                map.put('a', map.get('a') + 1);
            }else if(arr[i] == 'a') {
                if(map.get('a') == 0) return -1;
                map.put('a', map.get('a') - 1);
                map.put('k', map.get('k') + 1);
            }else if(arr[i] == 'k') {
                if(map.get('k') == 0) return -1;
                map.put('k', map.get('k') - 1);
                now -= 1;
            }
        }

        if(map.get('r') != 0 || map.get('o') != 0 || map.get('a') != 0 || map.get('k') != 0) return -1;


        return ans;
    }
}
