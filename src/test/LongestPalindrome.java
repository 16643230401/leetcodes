package test;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2019-12-29 12:30
 */
public class LongestPalindrome {

    /**
     * 5.最长回文子串
     * @param args
     */
    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome("bb"));

    }

    public String longestPalindrome(String s) {
        if(s.length() == 0) {
            return "";
        }
        String ans;
        int maxLength = 1;
        int left;
        int right;
        ans = String.valueOf(s.charAt(0));
        for (int i = 0; i < s.length(); i++) {
            left = i;
            right = i;
            while (left >= 0 && right <= s.length() - 1) {
                if (s.charAt(left) == s.charAt(right)) {
                    left --;
                    right ++;
                } else if (s.charAt(left) != s.charAt(right)) {
                    break;
                }
            }
            left ++;
            right --;
            if(right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                ans = s.substring(left, right + 1);
            }

            if(i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                left = i;
                right = i + 1;
                while (left >= 0 && right <= s.length() - 1) {
                    if (s.charAt(left) == s.charAt(right)) {
                        left --;
                        right ++;
                    } else if (s.charAt(left) != s.charAt(right)) {
                        break;
                    }
                }
                left ++;
                right --;
                if(right - left + 1 > maxLength) {
                    maxLength = right - left + 1;
                    ans = s.substring(left, right + 1);
                }
            }

        }




        return ans;
    }

    public String[] check(int left, int right, String s) {
        String[] strs = new String[2];



        return strs;
    }
}
