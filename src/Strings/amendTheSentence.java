package Strings;

/**
 * @ClassName:amendTheSentence
 * @Auther: yyj
 * @Description:
 * @Date: 25/10/2022 19:25
 * @Version: v1.0
 */
public class amendTheSentence {


    String solution(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ;i<s.length();i++){
            if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                if(i != 0){
                    sb.append(" ");
                }
                sb.append((char)(s.charAt(i) - 'A' + 'a'));
            }else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();

    }

}
