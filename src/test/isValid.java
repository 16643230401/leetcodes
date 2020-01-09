package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class isValid {

    public static void main(String[] args) {
        isValid isValid = new isValid();
        System.out.println(isValid.isValid_Formal("([)]"));
//        System.out.println('{' + 1);
    }

    public boolean isValid(String s) {
        if (s.length() == 0) return true;
        if (s.length() % 2 != 0) return false;
        Stack<String> stack = new Stack<>();
        stack.push(String.valueOf(s.charAt(0)));
        Map<String, String> map = new HashMap<>();
        map.put(")", "(");
        map.put("]", "[");
        map.put("}", "{");
        String lefts = "([{";
        String rights = ")]}";
        for (int i = 1; i < s.length(); i++) {
            if (lefts.contains(String.valueOf(s.charAt(i)))) {
                stack.push(String.valueOf(s.charAt(i)));
            } else {
                if (rights.contains(stack.peek())) {
                    stack.push(String.valueOf(s.charAt(i)));
                } else if (stack.peek().equals(map.get(String.valueOf(s.charAt(i))))) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;

    }


    public boolean isValid_Formal(String s) {
        if (s.length() % 2 == 1) return false;
        char[] chars = s.toCharArray();
        char[] cs = new char[s.length() / 2 + 1];
        int j = 0;
        char c1, c2;
        for (int i = 0; i < chars.length && j < cs.length; i++) {
            c1 = chars[i];
            if (c1 == '(' || c1 == '{' || c1 == '[') {
                cs[j] = c1;
                j++;
                continue;
            }
            if (j == 0) return false;
            c2 = cs[j - 1];
            j--;
            if (c1 != c2 + 1 && c1 != c2 + 2) return false;
        }
        return j == 0;
    }
}
