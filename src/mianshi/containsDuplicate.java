package mianshi;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-05-05 21:09
 */
public class containsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if(set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }
}
