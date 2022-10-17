package HashTable;

import java.util.*;

/**
 * @ClassName:possibleSums
 * @Auther: yyj
 * @Description:
 * @Date: 17/10/2022 22:30
 * @Version: v1.0
 */
public class possibleSums {

    public static void main(String[] args) {
        possibleSums ss = new possibleSums();
        ss.solution(new int[]{10, 50, 100}, new int[]{1,2,1});

    }
    int solution(int[] coins, int[] quantity) {
        Set<Integer> set = new HashSet<>();
        set.add(0);
        for(int i = 0; i < quantity.length; i++){
            List<Integer> sums = new ArrayList<Integer>(set);
            for(Integer k : sums){
                for(int j = 1; j <= quantity[i]; j++){
                    set.add(k + j * coins[i]);
                }
            }
        }
        return set.size()-1;
    }
}
