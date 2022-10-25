package GeneralTopic;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName:sumOfTwo
 * @Auther: yyj
 * @Description:
 * @Date: 24/10/2022 22:49
 * @Version: v1.0
 */
public class sumOfTwo {

    boolean solution(int[] a, int[] b, int v) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ;i<a.length;i++){
            set.add( v-a[i]);
        }

        for(int i = 0 ;i<b.length;i++){
            if (set.contains(b[i])) return true;
        }
        return false;
    }
}
