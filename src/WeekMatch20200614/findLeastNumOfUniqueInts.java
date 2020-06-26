package WeekMatch20200614;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-06-14 10:42
 */
public class findLeastNumOfUniqueInts {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        if(arr.length == 1 && k > 0) return 0;
        if(arr.length == 1 && k <= 0) return 1;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if(!map.keySet().contains(arr[i])) map.put(arr[i], 1);
            else map.put(arr[i], map.get(arr[i]) + 1);
        }

        List<Integer> list = new ArrayList<>(map.values());

        Collections.sort(list, (o1, o2)->o1 - o2);


        int ans = list.size();
        for (int i = 0; i < list.size(); i++) {
            if(k < list.get(i)) return ans;
            k -= list.get(i);
            ans --;
        }

        return ans;
    }
}
