package test;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2019-08-03 13:30
 * @problem 6.Z字形变换
 */
public class ZigZag {
    public static void main(String[] args) {
        System.out.println(ZigZag.ZigZag("LEETCODEISHIRING", 4));
    }
    public static String ZigZag(String s, int numRows) {
        if(numRows == 1) return s;
        int sumOfOne = numRows + numRows - 2;
        int numColumns = (s.length() % sumOfOne == 0) ? s.length() / sumOfOne : s.length() / sumOfOne + 1;
        char[][] arr = new char[numRows][numColumns * (numRows - 1)];
        int flagPoint = 0;
        int row = 0, column = 0;
        while(flagPoint < s.length()) {
            while(row < numRows && flagPoint < s.length()) {
                arr[row++][column] = s.charAt(flagPoint++);
            }
            row -= 2;
            column ++;
            while(row > 0 && flagPoint < s.length()) {
                arr[row--][column++] = s.charAt(flagPoint++);
            }
        }
        String ans = new String();
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < numColumns * (numRows - 1); j++) {
                if(arr[i][j] != 0) {
                    ans += arr[i][j];
                }
            }
        }

        return ans;


    }
}


//1   9
//2  810
//3 7 11
//46  12
//5   13








