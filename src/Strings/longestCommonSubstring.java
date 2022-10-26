package Strings;

/**
 * @ClassName:longestCommonSubstring
 * @Auther: yyj
 * @Description:
 * @Date: 26/10/2022 16:19
 * @Version: v1.0
 */
public class longestCommonSubstring {
    public static void main(String[] args) {
        longestCommonSubstring test = new longestCommonSubstring();
        test.solution("zxabcdezy","yzabcdezx");

    }
    // timeout

    int solution(String s, String t) {
        int n = s.length();
        int m = t.length();
        int max = 0;

        int[][] dp = new int[ n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] =dp[i-1][j-1]+ 1;
                    max = Math.max( dp[i][j],max);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return max;
    }
}
