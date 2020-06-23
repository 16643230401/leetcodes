package WeekMatch20200412;

import sun.security.x509.AttributeNameEnumeration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-04-12 10:32
 */
public class stringMatching {

    public List<String> stringMatching(String[] words) {

        List<String> ans;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            for (int l = i + 1; l < words.length; l++) {
                if(words[i].contains(words[l])) {
                    set.add(words[l]);
                }
                if(words[l].contains(words[i])) {
                    set.add(words[i]);
                }
            }
        }

        ans = new ArrayList<>(set);
        return ans;
    }
}
