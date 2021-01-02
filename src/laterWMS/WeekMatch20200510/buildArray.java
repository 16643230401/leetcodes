package laterWMS.WeekMatch20200510;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-05-10 10:41
 */
public class buildArray {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        int flag = 1;
        for (int i = 0; i < target.length; i++) {
            if(target[i] == flag) {
                ans.add("Push");
            } else {
                ans.add("Push");
                ans.add("Pop");
                i --;
            }
            flag ++;
        }

        return ans;
    }
}
