package laterWMS.WeekMatch20200531;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-05-31 11:31
 */
public class minReorder {

    public int minReorder(int n, int[][] connections) {
        Set<Integer> nodeSet = new HashSet<>();
        nodeSet.add(0);
        int ans = 0;

        while(nodeSet.size() < n) {
            for (int i = 0; i < n - 1; i++) {
                if(nodeSet.contains(connections[i][0])) {
                    ans += 1;
                    nodeSet.add(connections[i][1]);
                } else if(nodeSet.contains(connections[i][1])){
                    nodeSet.add(connections[i][0]);
                }
            }
        }

        return ans;
    }
}
