package Strings;

/**
 * @ClassName:strstr
 * @Auther: yyj
 * @Description:
 * @Date: 25/10/2022 19:52
 * @Version: v1.0
 */
public class strstr {

    public static void main(String[] args) {
        strstr test = new strstr();
        test.solution("CodefightsIsAwesome","IsA");
    }
    //CodefightsIsAwesome
    int solution(String s, String x) {
//        for(int i=0;i<=s.length()-x.length();i++){
//            String sub = s.substring(i,i+x.length());
//            if(sub.equals(x)){
//                return i;
//            }
//        }
//
//        return -1;
        String substring = "";
        if (s.length() < x.length()) return -1;
        for (int i = 0; i < s.length(); i++) {
            if ((i + x.length() - 1) >= s.length()) return -1;
            // check the first  char && last char
            if (s.charAt(i) == x.charAt(0) && s.charAt(i + x.length() - 1) == x.charAt(x.length() - 1)) {
                substring = s.substring(i, i + x.length());
                if (substring.equals(x)) return i;
            }
        }
        return -1;
    }

}
