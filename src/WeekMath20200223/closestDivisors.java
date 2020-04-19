package WeekMath20200223;

/**
 * 5171. 最接近的因数
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-02-23 11:50
 */
public class closestDivisors {

    public static void main(String[] args) {


    }

    public int[] closestDivisors(int num) {
        int n1 = (int) Math.sqrt(num + 1);
        int n2 = (int) Math.sqrt(num + 2);

        int[] arr = findNum(num, n1);
        int[] arr2 = findNum(num, n2);

        if(arr[1] - arr[0] > arr2[1] - arr2[0]) return arr2;
        return arr;
    }

    public int[] findNum(int num, int n) {
        for (int i = n; i >= 1; i--) {
            if(num % i == 0) {
                return new int[]{i,num / i};
            }
        }
        return new int[]{1, num};
    }
}
