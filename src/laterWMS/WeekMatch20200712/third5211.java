package laterWMS.WeekMatch20200712;

import java.util.*;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-07-12 11:09
 */
public class third5211 {

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            if(map.keySet().contains(edges[i][0])) {
                map.get(edges[i][0]).add(i);
            } else {
                map.put(edges[i][0], new ArrayList<>());
                map.get(edges[i][0]).add(i);
            }

            if(map.keySet().contains(edges[i][1])) {
                map.get(edges[i][1]).add(i);
            } else {
                map.put(edges[i][1], new ArrayList<>());
                map.get(edges[i][1]).add(i);
            }
        }





        Queue<Integer> queue = new LinkedList<>();
        double[] sz = new double[n];
        sz[start] = 1;

        queue.add(start);

        while(!queue.isEmpty()) {
            int num = queue.poll();

//            for (int i = 0; i < edges.length; i++) {
            if(!map.keySet().contains(num)) continue;
            for(int j = 0; j < map.get(num).size(); j++) {
                int i = map.get(num).get(j);
                if(edges[i][0] == num) {
                    if(sz[edges[i][1]] == 0) {
                        sz[edges[i][1]] = sz[edges[i][0]] * succProb[i];
                        queue.offer(edges[i][1]);
                    }
                    else {
                        if(sz[edges[i][1]] < sz[edges[i][0]] * succProb[i]) {
                            sz[edges[i][1]] = sz[edges[i][0]] * succProb[i];
                            queue.offer(edges[i][1]);
                        }

                    }
                }

                if(edges[i][1] == num) {
                    if(sz[edges[i][0]] == 0) {
                        sz[edges[i][0]] = sz[edges[i][1]] * succProb[i];
                        queue.offer(edges[i][0]);
                    }
                    else {
                        if(sz[edges[i][0]] < sz[edges[i][1]] * succProb[i]) {
                            sz[edges[i][0]] = sz[edges[i][1]] * succProb[i];
                            queue.offer(edges[i][0]);
                        }

                    }
                }
            }



        }





        return sz[end];
    }
}
