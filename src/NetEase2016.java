import java.util.*;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-02-17 20:42
 */
public class NetEase2016 {
    public static void main(String[] args) {
        NetEase2016 NetEase2016 = new NetEase2016();
        NetEase2016.Solution();

    }

    public int Solution() {
        Set<Integer[]> set = new HashSet<>();
        set.add(new Integer[]{3,5,6});
        set.add(new Integer[]{3,4,7});
        List<Integer[]> list = new ArrayList<>(set);

        Collections.sort(list, (a, b)->{
            for (int i = 0; i < 3; i++) {
                if(a[i] != b[i])
                    return a[i] - b[i];
            }
            return 0;
        });

        for (Integer[] integers : list) {
            for (Integer integer : integers) {
                System.out.print(integer);
            }
            System.out.println();
        }

        return 0;
    }


}
