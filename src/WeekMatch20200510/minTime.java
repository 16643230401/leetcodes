package WeekMatch20200510;

import java.util.*;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-05-10 11:31
 */
public class minTime {

    public static void main(String[] args) {
//        minTime minTime = new minTime();
//        minTime.minTime(7, new int[][]{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}});
    }


    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        int[] father = new int[n];
        for (int[] edge : edges) {
            father[edge[1]] = edge[0];
        }
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < hasApple.size(); i++) {
            if(hasApple.get(i)) {
                int temp = i;
                ans += 1;
                set.add(temp);
                while(father[temp] != 0 && !set.contains(father[temp])) {
                    ans += 1;
                    temp = father[temp];
                    set.add(temp);
                    if(hasApple.get(temp)) hasApple.set(temp, false);
                }
            }
        }
        return ans * 2;

    }
}
