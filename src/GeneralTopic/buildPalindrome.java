package GeneralTopic;

/**
 * @ClassName:buildPalindrome
 * @Auther: yyj
 * @Description:
 * @Date: 17/10/2022 12:23
 * @Version: v1.0
 */
public class buildPalindrome {
    //https://app.codesignal.com/arcade/intro/level-10/ppZ9zSufpjyzAsSEx
    String solution(String st) {
        int i = 0;
        while(!st.equals(new StringBuffer(st).reverse().toString())){
            st = new StringBuilder(st).insert(st.length()-i,st.charAt(i)).toString();
            i++;
        }
        return st;
    }
}
