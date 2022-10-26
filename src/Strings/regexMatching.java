package Strings;

/**
 * @ClassName:regexMatching
 * @Auther: yyj
 * @Description:
 * @Date: 26/10/2022 16:18
 * @Version: v1.0
 */
public class regexMatching {


    public static void main(String[] args) {
        regexMatching test = new regexMatching();
        test.solution("nal$","codesignal");

    }
    boolean solution(String pattern, String test) {
        int len = 0;
        if(pattern.contains("^")){
            len =  pattern.length() - 1;
            String sub = test.substring(0,len);
            if(sub.equals(pattern.substring(1))) return true;
            else return false;

        }else if(pattern.contains("$")){
            len =  pattern.length() - 1;
            String sub = test.substring(test.length()-len);
            if(sub.equals(pattern.substring(0,len))) return true;
            else return false;
        }

        if(test.contains(pattern)) return true;
        return false;

    }

}
