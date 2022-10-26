package Strings;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName:classifyStrings
 * @Auther: yyj
 * @Description:
 * @Date: 25/10/2022 21:02
 * @Version: v1.0
 */
public class classifyStrings {

    /**
     *
     * You categorize strings into three types: good, bad, or mixed. If a string has 3 consecutive vowels or 5 consecutive consonants,
     * or both, then it is categorized as bad. Otherwise it is categorized as good.
     * Vowels in the English alphabet are ["a", "e", "i", "o", "u"] and all other letters are consonants.
     *
     * The string can also contain the character ?, which can be replaced by either a vowel or a consonant.
     * This means that the string "?aa" can be bad if ? is a vowel or good if it is a consonant. This kind of string is categorized as mixed.
     *
     * Implement a function that takes a string s and returns its category: good, bad, or mixed.
     *
     * Example
     *
     * For s = "aeu", the output should be
     * solution(s) = "bad";
     *
     * For s = "a?u", the output should be
     * solution(s) = "mixed";
     *
     * For s = "aba", the output should be
     * solution(s) = "good".
     * **/

    public static void main(String[] args) {
        classifyStrings test = new classifyStrings();
        test.solution("???");
    }
    String solution(String s) {
        if(s.equals("?")) return "good";
        String[] vowels = new String[]{"a", "e", "i", "o", "u"};
        Set<String> set = new HashSet<>();
        for(String v : vowels) set.add(v);
        int left = 0;
        int count = 0;
        boolean vowelFound = false, qmarkFound = false;
        while (left < s.length()) {
            char cur = s.charAt(left);
            if (set.contains(String.valueOf(cur))) {
                if (vowelFound) {
                    count++;
                    if (count == 3) return qmarkFound ? "mixed" : "bad";
                } else count = 1;
                qmarkFound = false;
                vowelFound = true;

            } else if (cur != '?') {
                if (!vowelFound) {
                    count++;
                    if (count == 5) return qmarkFound ? "mixed" : "bad";
                } else count = 1;
                qmarkFound = false;
                vowelFound = false;
            } else {
                if ((vowelFound && count == 2) || (!vowelFound && count == 4)) return "mixed";
                count++;
                qmarkFound = true;
            }
            left++;


        }
        return "good";



    }

}
