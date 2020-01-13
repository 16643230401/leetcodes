package test;

/**
 * <p>最长公共前缀</p>
 *
 * @Author : bairuoyu
 * @Date : 2020-01-11
 * @Version : v1.0
 */
public class longestCommonPrefix {
    public static void main(String[] args) {
        longestCommonPrefix longestCommonPrefix = new longestCommonPrefix();
//        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        String ss = "12345";
        System.out.println(ss.indexOf("34"));
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        String ans = "";

        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i)) {
                    return ans;
                }
            }
            ans += strs[0].charAt(i);
        }

        return ans;

    }
}
