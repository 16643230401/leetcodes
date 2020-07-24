package EveryDay;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-07-16 21:33
 */
public class isBipartite {

    public boolean isBipartite(int[][] graph) {
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        setA.add(0);
        for (int i = 0; i < graph[0].length; i++) {
            setB.add(graph[0][i]);
        }
        for (int i = 1; i < graph.length; i++) {
            if(setA.contains(i) && setB.contains(i)) return false;

            if(setA.contains(i)) {
                for (int j = 0; j < graph[i].length; j++) {
                    if(setB.contains(graph[i][j])) return false;
                    setB.add(graph[i][j]);
                }
            } else {
                for (int j = 0; j < graph[i].length; j++) {
                    if(setA.contains(graph[i][j])) return false;
                    setA.add(graph[i][j]);
                }
            }


        }

        return true;
    }
}
