package EveryDay;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-08-04 22:52
 */
public class canFinish {
    int[] visit;
    List<List<Integer>> edges;
    boolean ans = true;


    /**
     * dfs判断图中是否存在环
     * @param n
     * @param p
     * @return
     */
//    public boolean canFinish(int n, int[][] p) {
//        visit = new int[n];
//        edges = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            edges.add(new ArrayList<>());
//        }
//
//        for (int i = 0; i < p.length; i++) {
//            edges.get(p[i][0]).add(p[i][1]);
//        }
//
//        for (int i = 0; i < edges.size(); i++) {
//            if(visit[i] == 0) dfs(i);
//        }
//        return ans;
//    }


    public void dfs(int k){
        visit[k] = 1;

        for (int i = 0; i < edges.get(k).size(); i++) {
            if(!ans) return;
            if(visit[edges.get(k).get(i)] == 0) dfs(edges.get(k).get(i));
            else if(visit[edges.get(k).get(i)] == 1) ans = false;
        }

        visit[k] = 2;
    }


    /**
     * 拓扑排序（用bfs实现拓扑排序，用list+len代替队列，但是感觉更慢了。。。）
     * @param n
     * @param p
     * @return
     */
    public boolean canFinish(int n, int[][] p) {
        visit = new int[n];
        edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }

        for (int i = 0; i < p.length; i++) {
            edges.get(p[i][0]).add(p[i][1]);
            visit[p[i][1]] ++;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(visit[i] == 0) list.add(i);
        }
        int len = list.size();

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < edges.get(list.get(i)).size(); j++) {
                visit[edges.get(list.get(i)).get(j)] --;
                if(visit[edges.get(list.get(i)).get(j)] == 0) {
                    list.add(edges.get(list.get(i)).get(j));
                    len ++;
                }
            }
        }
        return list.size() == n;
    }



}
