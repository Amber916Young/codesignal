package HashTable;

/**
 * @ClassName:areFollowingPatterns
 * @Auther: yyj
 * @Description:
 * @Date: 17/10/2022 12:19
 * @Version: v1.0
 */
public class areFollowingPatterns {

    public static void main(String[] args) {
        solution(new String[]{"cat", "dog", "doggy"},new String[]{"a", "b", "b"});
    }
    static boolean solution(String[] strings, String[] patterns) {
        for(int i = 0 ;i<strings.length ;i++){
            String str = strings[i];
            String patt1 = patterns[i];
//            System.out.println(patt1);
            for(int j = i+1 ;j< strings.length ;j++){
                String str2 = strings[j];
                String patt2 = patterns[j];
//                System.out.println(patt2);
                if( (!str.equals(str2) && patt1.equals(patt2)) || (str.equals(str2) && !patt1.equals(patt2))){
                    return false;
                }
            }
        }
        return true;
    }


}
