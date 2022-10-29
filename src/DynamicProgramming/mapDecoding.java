package DynamicProgramming;

/**
 * @ClassName:mapDecoding
 * @Auther: yyj
 * @Description: https://app.codesignal.com/interview-practice/question/cHYqbQ9DiWmejAdeG/description
 * @Date: 29/10/2022 14:22
 * @Version: v1.0
 */
public class mapDecoding {


    /***
     * A top secret message containing uppercase letters from 'A' to 'Z' has been encoded as numbers using the following mapping:
     *
     * 'A' -> 1
     * 'B' -> 2
     * ...
     * 'Z' -> 26
     * You are an FBI agent and you need to determine the total number of ways that the message can be decoded.
     *
     * Since the answer could be very large, take it modulo 10^9 + 7.
     *         int mod= 1000000007;
     *
     * For message = "123", the output should be
     * solution(message) = 3.
     * "123" can be decoded as "ABC" (1 2 3), "LC" (12 3) or "AW" (1 23), so the total number of ways is 3.
     * **/


    int solution(String message) {
        if (message == null) return 0;
        if (message.length() == 0) return 1;
        int mod = 1000000007;
        int[] dp = new int[message.length() + 1];
        dp[0] = 1;
        dp[1] = message.charAt(0) == '0' ? 0 : 1;

        for(int i = 2;i<=message.length();i++){
            int one = Integer.parseInt(message.substring(i-1,i));
            int two = Integer.parseInt(message.substring(i-2,i));
            if(one != 0) dp[i] += dp[i-1] % mod;
            if(two >= 10 && two <= 26) dp[i] += dp[i-2]  % mod;
        }
        return dp[message.length()];
    }
}
