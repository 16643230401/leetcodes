package WeekMatch20200412;

import java.util.*;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-04-12 10:55
 */
public class processQueries {

    public int[] processQueries(int[] queries, int m) {
        List<Integer> list = new LinkedList<>();
        int[] ans = new int[queries.length];
        for (int i = 0; i < m; i++) {
            list.add(i + 1);
        }
        int temp = 0;
        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < list.size(); j++) {
                if(list.get(j) == queries[i]) {
                    temp = list.get(j);
                    list.remove(j);
                    list.add(0, temp);
                    ans[i] = j;
                }
            }
        }

        return ans;

    }
}
