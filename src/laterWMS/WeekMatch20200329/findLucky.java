package laterWMS.WeekMatch20200329;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-03-29 10:49
 */
public class findLucky {

    public int findLucky(int[] arr) {
        if(arr.length == 0) return -1;
        int ans = -1;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : arr) {
            if(map.keySet().contains(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            if(integerIntegerEntry.getKey().equals(integerIntegerEntry.getValue())) {
                ans = ans > integerIntegerEntry.getValue() ? ans : integerIntegerEntry.getValue();
            }
        }



        return ans;
    }
}
