package WeekMatches;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-09-13 11:09
 */
public class WeekMatch20200913 {

    /**
     * 2题
     * @param n
     * @param preferences
     * @param pairs
     * @return
     */
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int ans = 0;
        //记录排名
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < pairs.length; i++) {
            for (int j = 0; j < preferences[pairs[i][0]].length; j++) {
                if(preferences[pairs[i][0]][j] == pairs[i][1]){
                    map.put(pairs[i][0], j);
                    break;
                }
            }

            for (int j = 0; j < preferences[pairs[i][1]].length; j++) {
                if(preferences[pairs[i][1]][j] == pairs[i][0]) {
                    map.put(pairs[i][1], j);
                    break;
                }
            }
        }

        for (int i = 0; i < pairs.length; i++) {
            for (int j = 0; j < preferences[pairs[i][0]].length; j++) {
                if(preferences[pairs[i][0]][j] == pairs[i][1]) break;
                int temp = 0;
                for (int k = 0; k < preferences[preferences[pairs[i][0]][j]].length; k++) {
                    if(preferences[preferences[pairs[i][0]][j]][k] == pairs[i][0]) {
                        temp = k;
                        break;
                    }
                }

                if(map.get(preferences[pairs[i][0]][j]) > temp) {
                    ans += 1;
                    break;
                }

            }

            for (int j = 0; j < preferences[pairs[i][1]].length; j++) {
                if(preferences[pairs[i][1]][j] == pairs[i][0]) break;
                int temp = 0;
                for (int k = 0; k < preferences[preferences[pairs[i][1]][j]].length; k++) {
                    if(preferences[preferences[pairs[i][1]][j]][k] == pairs[i][1]) {
                        temp = k;
                        break;
                    }
                }

                if(map.get(preferences[pairs[i][1]][j]) > temp) {
                    ans += 1;
                    break;
                }

            }
        }
        return ans;
    }


    /**
     * #3
     * @param points
     * @return
     */

    int[] father;
    int num;

    class struct{
        public int n1;
        public int n2;
        public int length;

        @Override
        public String toString() {
            return "struct{" +
                    "n1=" + n1 +
                    ", n2=" + n2 +
                    ", length=" + length +
                    '}';
        }
    }

    public int minCostConnectPoints(int[][] points) {
        init(points);
        List<struct> list = new ArrayList<>();
        struct s;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                s = new struct();
                s.length = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                s.n1 = i;
                s.n2 = j;
                list.add(s);
            }
        }

        Collections.sort(list, (o1, o2)->o1.length - o2.length);

        int ans = 0;
        for (struct st : list) {
            if(union(st.n1, st.n2)) {
                ans += st.length;
                System.out.println(st.toString());
            }
        }

        return ans;
    }

    public void init(int[][] points){
        num = points.length;
        father = new int[num];

        for (int i = 0; i < father.length; i++) {
            father[i] = i;
        }
    }


    public boolean union(int x, int y){
        int i = find(x);
        int j = find(y);

        if(i == j) return false;
        father[i] = j;
        return true;
    }


    public int find(int p) {
        if(p != father[p]) {
            father[p] = find(father[p]);
        }
        return father[p];
    }


    public static void main(String[] args) {
        int[][] p = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        WeekMatch20200913 a = new WeekMatch20200913();
        a.minCostConnectPoints(p);

    }





}
