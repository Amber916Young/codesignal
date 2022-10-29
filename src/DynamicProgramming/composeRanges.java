package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:composeRanges
 * @Auther: yyj
 * @Description: https://app.codesignal.com/interview-practice/question/cHYqbQ9DiWmejAdeG/description
 * @Date: 29/10/2022 13:49
 * @Version: v1.0
 */
public class composeRanges {

    public static void main(String[] args) {
        solution(new int[]{-1, 0, 1, 2, 6, 7, 9});
    }
    /**
     * Given a sorted integer array that does not contain any duplicates, return a summary of the number ranges it contains.
     * Example
     * For nums = [-1, 0, 1, 2, 6, 7, 9], the output should be
     * solution(nums) = ["-1->2", "6->7", "9"].
     * **/
    static String[]  solution(int[] nums) {
        if(nums.length == 0) return new String[]{};
        List< List<Integer>> res = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);
        for(int i = 1;i<nums.length;i++){
            if(Math.abs(nums[i-1] - nums[i]) == 1){
                sub.add(nums[i]);
            }else {
                res.add(new ArrayList<>(sub));
                sub = new ArrayList<>();
                sub.add(nums[i]);
            }
        }
        if(sub.size()>0)  res.add(sub);


        String[] ans = new String[res.size()];
        int index = 0;
        for(List<Integer> item : res ){
            StringBuilder sb = new StringBuilder();
            if(item.size()!=1){
                sb.append(item.get(0));
                sb.append("->");
                sb.append(item.get(item.size()-1));
            }else {
                sb.append(item.get(0));
            }

            ans[index++] = sb.toString();
        }
        return ans;
    }



}
