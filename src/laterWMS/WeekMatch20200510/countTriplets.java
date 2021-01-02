package laterWMS.WeekMatch20200510;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-05-10 10:56
 */
public class countTriplets {

    public static void main(String[] args) {
        countTriplets countTriplets = new countTriplets();
        int[] arr = {2,3,1,6,7};
        countTriplets.countTriplets(arr);

    }

    public int countTriplets(int[] arr) {

        int a;
        int b;
        int ans = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            a = 0;
            for (int j = i + 1; j < arr.length; j++) {
                a = a ^ arr[j - 1];
                b = arr[j];
                if(a == b) {
                    ans += 1;
                    System.out.println(i + " " + j + " " + j);
                }
                for (int k = j + 1; k < arr.length; k++) {
                    b = b ^ arr[k];
                    if(a == b) {
                        ans += 1;
                        System.out.println(i + " " + j + " " + k);
                    }
                }
            }
        }

        return ans;
    }
}
