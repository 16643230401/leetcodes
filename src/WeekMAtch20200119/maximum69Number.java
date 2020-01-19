package WeekMAtch20200119;

/**
 * <p>69反转</p>
 *
 * @Author : bairuoyu
 * @Date : 2020-01-19
 * @Version : v1.0
 */
public class maximum69Number {
    public static void main(String[] args) {
        maximum69Number maximum69Number = new maximum69Number();
        System.out.println(maximum69Number.maximum69Number(9969));
    }

    public int maximum69Number (int num) {
        char[] arr = String.valueOf(num).toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == '6') {
                arr[i] = '9';
                break;
            }
        }
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans = ans * 10 + (arr[i] - '0');
        }

        return ans;
    }
}
