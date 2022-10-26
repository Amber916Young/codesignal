package Strings;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:textJustification
 * @Auther: yyj
 * @Description:
 * @Date: 26/10/2022 14:14
 * @Version: v1.0
 */
public class textJustification {

    public static void main(String[] args) {
        textJustification test = new textJustification();
        test.solution(new String[]{"This", "is", "an", "example", "of", "text", "justification."},16);

    }
    /***
     * Given an array of words and a length l, format the text such that each line
     * has exactly l characters and is fully justified on both the left and the right.
     * Words should be packed in a greedy approach; that is, pack as many words as possible in each line.
     * Add extra spaces when necessary so that each line has exactly l characters.
     *
     * Extra spaces between words should be distributed as evenly as possible.
     * If the number of spaces on a line does not divide evenly between words,
     * the empty slots on the left will be assigned more spaces than the slots on the right.
     * For the last line of text and lines with one word only,
     * the words should be left justified with no extra space inserted between them.
     *
     * Example
     *
     * For
     * words = ["This", "is", "an", "example", "of", "text", "justification."]
     * and l = 16, the output should be
     *
     * solution(words, l) = ["This    is    an",
     *                        "example  of text",
     *                        "justification.  "]
     *
     * */


    String[] solution(String[] words, int l) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            List<String> tmp = new ArrayList<>();
            int len = words[i].length();
            tmp.add(words[i]);
            while (i+1 < words.length && len + tmp.size() + words[i+1].length() <= l) {
                tmp.add(words[++i]);
                len += words[i].length();
            }
            String line =  tmp.get(0);
            for (int j = 1; j < tmp.size(); j++) {
                int differ  = tmp.size()-1;
                System.out.println((l - len) % differ);
                int spaces = i+1 < words.length ? ((l - len)/differ + ((j <= (l - len) % differ) ? 1 : 0)) : 1;
                for (int k = 1; k <= spaces; k++) {
                    line += " ";
                }
                line += tmp.get(j);
            }
            while (line.length() < l)
                line += " ";
            res.add(line);
        }
        return res.toArray(new String[res.size()]);
    }

}
