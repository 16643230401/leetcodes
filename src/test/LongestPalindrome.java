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
        System.out.println(longestPalindrome.longestPalindrome_DP2("cbbd"));

    }

    /**
     * 中心扩散法
     * @param s
     * @return
     */
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


    /**
     * DP(官方)
     *
     * 从初始状态开始检查是否符合，思路是记录当前状态后，检查下一个状态，所以不用每次都递归到初始状态
     *
     * @param s
     * @return
     */
    public String longestPalindrome_DP1(String s) {
        if(s.length() < 2) return s;

        boolean[][] arr = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            arr[i][i] = true;
        }

        int maxLen = 0;
        String ans = s.substring(0, 1);

        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i < j; i++) {
                if(s.charAt(i) == s.charAt(j)) {
                    arr[i][j] = i + 1 == j ? true : arr[i + 1][j - 1];
                } else {
                    arr[i][j] = false;
                }

                if(arr[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    ans = s.substring(i, j + 1);
                }
            }
        }

        return ans;
    }

    /**
     * DP（非官方）
     *
     * 不记录上一个状态，每一次都去寻找上一个状态，直到递归到初始状态。
     *
     *
     * @param s
     * @return
     */
    public String longestPalindrome_DP2(String s) {
        if(s.length() < 2) return s;
        int i = 0;
        int j = 0;
        int maxLen = 1;
        String ans = s.substring(0, 1);
        while (j < s.length()) {
            if(isNPalindorme(s, i, j)) {
                if(maxLen < j - i + 1) {
                    maxLen = j - i + 1;
                    ans = s.substring(i, j + 1);
                }
            }
            j ++;
        }
        j --;
        while (i < j) {
            if(isNPalindorme(s, i, j)) {
                if(maxLen < j - i + 1) {
                    maxLen = j - i + 1;
                    ans = s.substring(i, j + 1);
                }
            }
            i ++;
        }
        return ans;
    }

    public boolean isNPalindorme(String s, int i, int j) {
        if(i == j) {
            return true;
        }
        if(j == i + 1) {
            return s.charAt(i) == s.charAt(j);
        }
        return isNPalindorme(s, i + 1, j - 1) && s.charAt(i) == s.charAt(j);
    }

    public String[] check(int left, int right, String s) {
        String[] strs = new String[2];



        return strs;
    }
}
