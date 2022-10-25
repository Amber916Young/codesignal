package GeneralTopic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName:findLongestSubarrayBySum
 * @Auther: yyj
 * @Description:
 * @Date: 25/10/2022 13:11
 * @Version: v1.0
 */
public class findLongestSubarrayBySum {
    public static void main(String[] args) {
        findLongestSubarrayBySum test = new findLongestSubarrayBySum();
        test.solution(15,new int[]{1, 2, 3, 4, 5, 0, 0, 0, 6, 7, 8, 9, 10});
    }

    int[] solution(int s, int[] arr) {
        int curSum = 0;
        int[] ans = new int[]{-1};
        int left = 0;
        int right = 0;
        while (right < arr.length ) {
            curSum += arr[right];
            while (left < right && curSum > s){
                curSum -= arr[left];
                left++;
            }
            if (curSum == s ) {
                if (ans.length == 1 || ans[1] - ans[0] < right - left) {
                    ans = new int[]{left+1 ,right+1};
                }
            }
            right++;

        }


        return ans;
    }



}
