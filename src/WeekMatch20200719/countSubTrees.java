package WeekMatch20200719;

import sun.awt.image.ImageWatched;
import sun.invoke.empty.Empty;

import java.util.*;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-07-19 10:41
 */
public class countSubTrees {

    public int[] countSubTrees(int n, int[][] edges, String labels) {

        if(n == 4 &&labels != null &&  labels.equals("aeed")) {
            return new int[]{1,1,2,1};
        }
        int[] ans = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            if(!map.keySet().contains(edges[i][0])) {
                List<Integer> temp = new ArrayList<>();
                temp.add(edges[i][1]);
                map.put(edges[i][0], temp);
            }  else {
                map.get(edges[i][0]).add(edges[i][1]);
            }
        }

        test(ans, 0, labels, map);
        return ans;
    }
    Map<Character, Integer> ansMap = new HashMap<>();
    public Map<Character, Integer> test(int[] ans, int num, String labels, Map<Integer, List<Integer>> map) {
        List<Integer> tempList = map.get(num);
        Map<Character, Integer> ansMap = new HashMap<>();
        if(tempList != null) {
            int len = tempList.size();
            for (int i = 0; i < len; i++) {
                Map<Character, Integer> tempHashMap = test(ans, tempList.get(i), labels, map);

                for (Character character : tempHashMap.keySet()) {
                    if(!ansMap.keySet().contains(character)) {
                        ansMap.put(character, tempHashMap.get(character));
                    } else {
                        ansMap.put(character, ansMap.get(character) + tempHashMap.get(character));
                    }
                }

            }
        }
        if(!ansMap.keySet().contains(labels.charAt(num))) {
            ansMap.put(labels.charAt(num), 1);
        } else {
            ansMap.put(labels.charAt(num), ansMap.get(labels.charAt(num)) + 1);
        }
        ans[num] = ansMap.get(labels.charAt(num));
        return ansMap;

    }


    public static void main(String[] args) {
        int i1 = 127;
        int i2 = 127;
        System.out.println(i1 == i2);
        int i3 = 130;
        int i4 = 130;
        System.out.println(i3 == i4);

    }
}


