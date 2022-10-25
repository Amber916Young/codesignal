package GeneralTopic;

import java.util.HashMap;

/**
 * @ClassName:sumInRange
 * @Auther: yyj
 * @Description:
 * @Date: 24/10/2022 23:11
 * @Version: v1.0
 */
public class sumInRange {
    public static void main(String[] args) {
        sumInRange test = new sumInRange();
        test.solution(new int[]{3, 0, -2, 6, -3, 2},new int[][]{{0,2},{2,5},{0,5}});
    }

    int solution(int[] nums, int[][] queries) {
        int ans = 0;
        int mod= 1000000007;
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum  = 0;
        for(int i = 0; i<nums.length;i++){
            sum += nums[i];
            map.put(i,sum % mod);
        }
        for (int[] i : queries) {
            int start = i[0];
            int end = i[1];
            if(start == 0) {
                ans =  ans%mod + map.get(end)  ;
            }else {
                ans = ans%mod +  map.get(end) - map.get(start-1) ;
            }
        }
        return (ans + mod) % mod;

    }
}
