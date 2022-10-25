package GeneralTopic;

/**
 * @ClassName:productExceptSelf
 * @Auther: yyj
 * @Description:
 * @Date: 25/10/2022 14:22
 * @Version: v1.0
 */
public class productExceptSelf {
    public static void main(String[] args) {
        productExceptSelf test = new productExceptSelf();
        test.solution(new int[]{52, 40, 2, 78, 49, 70, 39, 26, 58, 58, 52, 93, 80, 64, 33, 72, 29, 17, 81, 83, 48, 9, 49, 82, 67, 76, 54, 64, 6, 48, 16, 82, 67, 56, 32, 98, 14, 47, 48, 26, 56, 54, 80, 13, 32, 18, 4, 73, 45, 65},530);
    }

    /**
     *
     * You have an array nums. We determine two functions to perform on nums. In both cases, n is the length of nums:
     *
     * fi(nums) = nums[0] · nums[1] · ... · nums[i - 1] · nums[i + 1] · ... · nums[n - 1]. (In other words, fi(nums) is the product of all array elements except the ithf.)
     * g(nums) = f0(nums) + f1(nums) + ... + fn-1(nums).
     * Using these two functions, calculate all values of f modulo the given m. Take these new values and add them together to get g. You should return the value of g modulo the given m.
     *
     * Example
     *
     * For nums = [1, 2, 3, 4] and m = 12, the output should be
     * solution(nums, m) = 2.
     *
     * The array of the values of f is: [24, 12, 8, 6]. If we take all the elements modulo m, we get:
     * [0, 0, 8, 6]. The sum of those values is 8 + 6 = 14, making the answer 14 % 12 = 2.
     * */
    int solution(int[] nums, int m) {
        int[] product = new int[nums.length];
        product[0] = 1;
        for(int i = 1 ;i<nums.length;i++){
            product[i] =  product[i-1] * nums[i-1]  % m;
        }
        int sum = 1;
        int ans = 0;

        for(int i = nums.length-1 ;i >= 0;i--){
            product[i] = sum * product[i] % m;
            ans +=  product[i];
            sum *= nums[i];
            sum %= m;
        }
        System.out.println(ans % m);
        return  ans % m;
    }

}
