package WeekMatch20200329;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-03-29 11:47
 */
public class numTeams {
    public int numTeams(int[] rating) {
        int ans = 0;
        for (int i = 0; i < rating.length; i++) {
            for (int j = i + 1; j < rating.length; j++) {
                for (int k = j + 1; k < rating.length; k++) {
                    if(rating[j] > rating[i] && rating[k] > rating[j]) {
                        ans ++;
                    } else if (rating[j] < rating[i] && rating[k] < rating[j]){
                        ans ++;
                    }
                }
            }
        }

        return ans;
    }
}
