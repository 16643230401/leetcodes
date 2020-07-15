package EveryDay;

import java.util.List;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-07-14 22:06
 */
public class minimumTotal {

    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        for (int i = len - 2; i >= 0; i--) {
            for (int j = 0; j < i + 1; j++) {
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
            }
        }

        return triangle.get(0).get(0);
    }

}
