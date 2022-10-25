package GeneralTopic;

/**
 * @ClassName:arrayMaxConsecutiveSum2
 * @Auther: yyj
 * @Description:
 * @Date: 25/10/2022 12:17
 * @Version: v1.0
 */
public class arrayMaxConsecutiveSum2 {
    public static void main(String[] args) {
        arrayMaxConsecutiveSum2 test = new arrayMaxConsecutiveSum2();
        test.solution(new int[]{-2, 2, 5, -11, 6});
    }


    int solution(int[] inputArray) {
        int max = Integer.MIN_VALUE;
        int currSum = inputArray[0];

        for (int i = 1; i < inputArray.length; i++) {
            currSum = Math.max( inputArray[i]+currSum, inputArray[i]);
            max = Math.max(max,currSum);

        }
        return max;

    }

}
