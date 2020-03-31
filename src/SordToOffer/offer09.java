package SordToOffer;

import java.util.Stack;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-03-02 21:14
 */
public class offer09 {

    class CQueue {
        Stack<Integer> s1;
        Stack<Integer> s2;

        public CQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        public void appendTail(int value) {
            s1.push(value);
        }

        public int deleteHead() {
            if(!s2.isEmpty()) {
                return s2.pop();
            } else if (!s1.isEmpty()) {

                int len = s1.size();
                for (int i = 0; i < len; i++) {
                    s2.push(s1.pop());
                }
                return s2.pop();
            }
            return -1;
        }
    }
}
