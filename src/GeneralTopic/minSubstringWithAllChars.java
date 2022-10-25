package GeneralTopic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName:minSubstringWithAllChars
 * @Auther: yyj
 * @Description:
 * @Date: 25/10/2022 15:13
 * @Version: v1.0
 */
public class minSubstringWithAllChars {
    public static void main(String[] args) {
        minSubstringWithAllChars test = new minSubstringWithAllChars();
        test.solution("adobecodebanc","abc");

    }

    /**
     * You have two strings, s and t. The string t contains only unique elements. Find and return the minimum consecutive substring of s that contains all of the elements from t.
     *
     * It's guaranteed that the answer exists. If there are several answers, return the one which starts from the smallest index.
     *
     * Example
     *
     * For s = "adobecodebanc" and t = "abc", the output should be
     * solution(s, t) = "banc".
     *
     * */
    String solution(String s, String t) {
        if(t.length() == 1) return t;
        if(t.equals("") || s.equals(""))  return "";
        //adobecodebanc
        Set<Character> set = new HashSet<>();

        int[] bound = new int[]{-1};
        for(int i = 0;i<s.length();i++) {
            char cur = s.charAt(i);
            for(char c : t.toCharArray() ){
                set.add(c);
            }
            if (set.contains(cur)) {
                set.remove(cur);
                for (int j = i + 1; j < s.length(); j++) {
                    if(set.contains(s.charAt(j))){
                        set.remove(s.charAt(j));
                    }
                    if(set.size() == 0){
                        if(bound.length == 1 || bound[1] -bound[0] > j-i){
                            bound = new int[]{i,j};
                        }
                        break;
                    }
                }

            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = bound[0]; i<=bound[1];i++){
            sb.append(s.charAt(i));
        }

        return sb.toString();

    }

}
