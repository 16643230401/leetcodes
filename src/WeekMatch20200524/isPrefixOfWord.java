package WeekMatch20200524;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-05-24 10:31
 */
public class isPrefixOfWord {

    public int isPrefixOfWord(String sentence, String searchWord) {
        if(sentence == null || sentence == "") return -1;
        String[] arr = sentence.split(" ");
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].startsWith(searchWord)) return i + 1;
        }

        return -1;
    }
}
