package EveryDay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-08-12 22:06
 */
public class cloneGraph {

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    Map<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        Node ans = dfs(node);
        return ans;
    }


    public Node dfs(Node node) {
        if(map.containsKey(node)) {
            return map.get(node);
        }

        Node ans = new Node();
        map.put(node, ans);
        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; i < node.neighbors.size(); i++) {
            list.add(dfs(node.neighbors.get(i)));
        }
        ans.val = node.val;
        ans.neighbors = list;
        return ans;
    }
}
