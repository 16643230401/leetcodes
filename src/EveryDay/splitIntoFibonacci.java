package EveryDay;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 12/8/20 10:57 PM
 */
public class splitIntoFibonacci {

    public static void main(String[] args) {

        splitIntoFibonacci s=  new splitIntoFibonacci();
        s.splitIntoFibonacci("0123");
    }

    public List<Integer> splitIntoFibonacci(String S) {
        int len = S.length();
        char[] c = S.toCharArray();
        List<Integer> ans = new ArrayList<>();
        back(ans, 0, c);
        return ans;

    }

    public boolean back(List<Integer> list, int start, char[] c) {
        if(start == c.length) return list.size() > 2;
        int tempSum = 0;
        for(int i = start; i < c.length; i++) {
            tempSum = tempSum * 10 + (c[i] - '0');
            if(i > start && tempSum == 0) return false;
            if(list.size() < 2) {
                list.add(tempSum);
                if(back(list, i + 1, c)) return true;
                list.remove(list.size() - 1);
            } else if(list.get(list.size() - 1) + list.get(list.size() - 2) - tempSum == 0) {
                list.add(tempSum);
                if(back(list, i + 1, c)) return true;
                list.remove(list.size() - 1);
            } else if(list.get(list.size() - 1) + list.get(list.size() - 2) - tempSum < 0) {
                return false;
            }
        }

        return false;
    }
}
