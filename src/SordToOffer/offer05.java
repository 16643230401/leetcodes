package SordToOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-02-26 21:36
 */
public class offer05 {
    public static void main(String[] args) {
        String s = "We are happy.";
        offer05 ans = new offer05();
        System.out.println(ans.replaceSpace(s));
    }

    public String replaceSpace(String s) {
        List<Character> list = new ArrayList<>();

        int SpaceNum = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                SpaceNum ++;
            }
            list.add(s.charAt(i));
        }

        for (int i = 0; i < SpaceNum; i++) {
            list.add(' ');
            list.add(' ');
        }

        int j = list.size() - 1;

        for (int length = s.length() - 1; length >= 0; length--) {
            if(s.charAt(length) == ' ') {
                list.set(j--, '0');
                list.set(j--, '2');
                list.set(j--, '%');
                continue;
            }
            list.set(j--, s.charAt(length));
        }

        StringBuilder ans = new StringBuilder();
        for (Character character : list) {
            ans.append(character);
        }

        return ans.toString();
    }

    public String replaceSpace2(String s) {
        StringBuilder strbud = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                strbud.append("%20");
                continue;
            }
            strbud.append(s.charAt(i));
        }

        return strbud.toString();

    }
}
