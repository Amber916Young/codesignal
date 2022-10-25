package GeneralTopic;

import java.util.Arrays;

/**
 * @ClassName:containsDuplicates
 * @Auther: yyj
 * @Description: prefix
 * @Date: 24/10/2022 22:47
 * @Version: v1.0
 */
public class containsDuplicates {

    boolean solution(int[] a) {
        Arrays.sort(a);
        for(int i = 1;i<a.length;i++){
           if(a[i-1] == a[i]) return true;
        }
        return false;
    }

}
