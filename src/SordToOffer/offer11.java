package SordToOffer;



/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-03-18 22:36
 */
public class offer11 {
    public int minArray(int[] numbers) {
        if(numbers.length == 1 || numbers[0] < numbers[numbers.length - 1]) return numbers[0];
        int left = 0;
        int right = numbers.length - 1;
        int minValue = Integer.MAX_VALUE;
        while(right - left > 1) {
            if(numbers[(left + right) / 2] == numbers[right] && numbers[(left + right) / 2] == numbers[left]) {
                for (int number : numbers) {
                    minValue = Math.min(minValue, number);
                }
                return minValue;
            }
            if(numbers[(left + right) / 2] < numbers[right]) {
                right = (left + right) / 2;
            } else {
                left = (left + right) / 2;
            }
        }

        return numbers[right];


    }
}
