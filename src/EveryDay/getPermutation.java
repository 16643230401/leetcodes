package EveryDay;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-09-05 19:23
 */
public class getPermutation {

    public static void main(String[] args) {
        getPermutation getPermutation = new getPermutation();

        getPermutation.getPermutation(3,3);
    }

    public String getPermutation(int n, int k) {
        int len = n;
        int[] arr = new int[n];
        for ( int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        int temp = n;
        int m = 1;
        while(temp > 1) {
            m *= temp;
            temp --;
        }
        m = m / n;
        n--;
        int pointer = 0;
        StringBuffer sb = new StringBuffer();
        while(k > m) {
            pointer = (k % m) == 0 ? k / m : k / m + 1;
            for ( int i = 0; i < len; i++) {
                if(arr[i] > 0) pointer --;
                if(pointer == 0) {
                    pointer = arr[i];
                    arr[i] = -1;
                    break;
                }
            }
            sb.append(String.valueOf(pointer));
            k = k % m;
            m = m / n;
            n = n - 1;
        }

        pointer = k;
        for ( int i = 0; i < len; i++) {
            if(arr[i] > 0) pointer --;
            if(pointer == 0) {
                pointer = arr[i];
                arr[i] = -1;
                break;
            }
        }
        sb.append(String.valueOf(pointer));

        for ( int i = 0; i < len; i++) {
            if(arr[i] > 0) sb.append(String.valueOf(arr[i]));
        }


        return sb.toString();
    }
}
