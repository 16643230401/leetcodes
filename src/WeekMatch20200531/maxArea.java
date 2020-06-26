package WeekMatch20200531;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-05-31 10:46
 */
public class maxArea {

    public static void main(String[] args) {

        int a = (int)Math.pow(10.0, 1.0);

        System.out.println((a));

    }

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long vmax = Math.max(verticalCuts[0], w - verticalCuts[verticalCuts.length - 1]);
        long hmax = Math.max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.length - 1]);

        for (int i = 1; i < verticalCuts.length || i < horizontalCuts.length ; i++) {
            if(i < verticalCuts.length)
                vmax = Math.max(vmax, verticalCuts[i] - verticalCuts[i - 1]);
            if(i < horizontalCuts.length)
                hmax = Math.max(hmax, horizontalCuts[i] - horizontalCuts[i - 1]);
        }

        long mod = (long)Math.pow(10.0, 9.0) + 7;

        return Long.valueOf((vmax * hmax) % mod).intValue();
    }
}
