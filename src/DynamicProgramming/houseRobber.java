package DynamicProgramming;

/**
 * @ClassName:houseRobber
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/house-robber/
 * @Date: 27/10/2022 12:10
 * @Version: v1.0
 */
public class houseRobber {
    public static void main(String[] args) {
        houseRobber test = new houseRobber();
        test.solution(new int[]{1,2,3,1});
    }
    /**
     * Input: nums = [1,2,3,1]
     * Output: 4
     * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
     * Total amount you can rob = 1 + 3 = 4.
     *
     * **/
    int solution(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int[] memo = new int[nums.length + 1];
        memo[0] = 0;
        memo[1] = nums[0];
        for(int i = 2;i< memo.length;i++){
            memo[i] = Math.max(nums[i-1]+memo[i-2],memo[i-1]);
        }
        return memo[nums.length+ 1];

    }

}
