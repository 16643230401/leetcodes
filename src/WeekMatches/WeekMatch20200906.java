package WeekMatches;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-09-06 15:14
 */
public class WeekMatch20200906 {

    public static void main(String[] args) {
        int[] nums1 = {43024,99908};
        int[] nums2 = {1864};
        System.out.println(numTriplets(nums1, nums2));

    }

    public String modifyString(String s) {
        if("".equals(s)) return "";
        if("?".equals(s)) return "a";
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == '?') {
                arr[i] = 'a';
                boolean flag = true;
                while(flag) {
                    flag = false;
                    if(i > 0 && arr[i - 1] != '?' && arr[i] == arr[i - 1]) {
                        arr[i]  = (char)('a' + (arr[i] - 'a' + 1) % 26);
                        flag = true;
                    }
                    if(i < arr.length - 1 && arr[i + 1] != '?' && arr[i] == arr[i + 1]) {
                        arr[i]  = (char)('a' + (arr[i] - 'a' + 1) % 26);
                        flag = true;
                    }
                }
            }
        }

        return String.valueOf(arr);


    }

//    'a' + (s - 'a' + 1) % 26



    public static int numTriplets(int[] nums1, int[] nums2) {
        Map<Long, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < nums2.length; i++) {
            for (int j = i + 1; j < nums2.length; j++) {
                Long num = (long)nums2[i] * (long)nums2[j];
                if(!map.containsKey(num)) {
                    map.put(num, 1);
                } else {
                    map.put(num,map.get(num) + 1);
                }
            }
        }

        for (int i : nums1) {
            if(map.containsKey((long)i * (long)i)) {
                ans += map.get((long)i * (long)i);
            }
        }
        map = new HashMap<>();




        for (int i = 0; i < nums1.length; i++) {
            for (int j = i + 1; j < nums1.length; j++) {
                Long num = (long)nums1[i] * (long)nums1[j];
                if(!map.containsKey(num)) {
                    map.put(num, 1);
                } else {
                    map.put(num,map.get(num) + 1);
                }
            }
        }

        for (int i : nums2) {
            if(map.containsKey((long)i * (long)i)) {
                ans += map.get((long)i * (long)i);
            }
        }

        return ans;
    }





    public int minCost(String s, int[] cost) {
        char[] arr = s.toCharArray();
        int len = s.length();

        int left = 0;
        int right = left;
        int ans = 0;
        while(left < len) {
            while(right < len && (right == len - 1 || (right < len - 1 && arr[right] == arr[right + 1]))) {
                right ++;
            }
            if(left < right) {
                int max = -1;
                for (int i = left; i <= right; i++) {
                    ans += cost[i];
                    max = Math.max(max, arr[i]);
                }
                ans -= max;
            }

            left = right + 1;
            right = left;
        }
        return ans;
    }


    /**
     * 5510. 保证图可完全遍历
     * @param n
     * @param edges
     * @return
     */
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        initUF(n, edges);
        Arrays.sort(edges, (e1, e2) -> e2[0] - e1[0]);
        if(getConnectionOneByOne(n, edges, 1)) return -1;
        for (int i = 0; i < n + 1; i++) {
            father[i] = i;
        }
        if(getConnectionOneByOne(n, edges, 2)) return -1;

        int ans = 0;
        for (boolean b : used) {
            if(!b) ans += 1;
        }

        return ans;
    }


    public boolean getConnectionOneByOne(int n, int[][] edges, int excuMod) {
        for (int i = 0; i < edges.length; i++) {
            if(edges[i][0] == excuMod) continue;
            union(edges[i], i);
        }

        int count = 0;
        for (int i = 2; i < father.length; i++) {
            if(father[i] == i) count ++;
        }
        return count == 1;
    }

    int[] father;
    int[] sz;
    int num;
    boolean[] used;

    //获取根节点
    public int find(int p) {
        if (p != father[p]) {
            //压缩路径
            father[p] = find(father[p]);
        }
        return father[p];
    }
    public void union(int[] edge, int index) {
        int i = find(edge[1]);
        int j = find(edge[2]);
        if (i == j) return;
        father[i] = j;
        used[index] = true;
    }

    public void initUF(int n, int[][] edges) {
        father = new int[n + 1];
        used = new boolean[edges.length];
        for (int i = 0; i < n + 1; i++) {
            father[i] = i;
        }
    }
}
