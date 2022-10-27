package DynamicProgramming;

/**
 * @ClassName:climbingStairs
 * @Auther: yyj
 * @Description:
 * @Date: 27/10/2022 12:09
 * @Version: v1.0
 */
public class climbingStairs {
    int solution(int n) {
        if(n <= 3) return n;
        int[] memo = new int[n+1];
        memo[0] = 1;
        memo[1] = 1;
        for(int i = 2 ;i <= n ;i++ ){
            memo[i] = memo[i-1] + memo[i-2];
        }
        return memo[n];
    }

}
