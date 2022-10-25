package Backtracking;

import java.util.*;

/**
 * @ClassName:combinationSum
 * @Auther: yyj
 * @Description:
 * @Date: 24/10/2022 22:20
 * @Version: v1.0
 */
public class combinationSum {

    public static void main(String[] args) {
        combinationSum test = new combinationSum();
        test.solution(new int[]{2, 3, 5, 9},9);
    }
    /**
     * Given an array of integers a and an integer sum, find all of the unique combinations in a that add up to sum.
     * The same number from a can be used an unlimited number of times in a combination.
     * Elements in a combination (a1 a2 … ak) must be sorted in non-descending order, while the combinations themselves must be sorted in ascending order.
     * If there are no possible combinations that add up to sum, the output should be the string "Empty".
     *
     * For a = [2, 3, 5, 9] and sum = 9, the output should be
     * solution(a, sum) = "(2 2 2 3)(2 2 5)(3 3 3)(9)".
     * **/

    List<List<Integer>> list = new ArrayList<>();
    String solution(int[] a, int sum) {
        List<Integer> tmp = new ArrayList<>();
        Arrays.sort(a);
        combinationSum_DFS(a,0,sum,tmp);
        StringBuilder ans = new StringBuilder();
        Set<String> set = new HashSet<>();
        if(list.size() == 0) return "Empty";

        for(List<Integer> s : list){
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            for(int i = 0 ;i < s.size();i++){
                if(i == s.size()-1) sb.append(s.get(i));
                else sb.append(s.get(i)+" ");
            }
            sb.append(")");
            if(!set.contains(sb.toString())){
                ans.append(sb);
            }
            set.add(sb.toString());
        }
        return ans.toString();
    }

    private void combinationSum_DFS(int[] a,int start, int sum, List<Integer> tmp) {
        if(sum < 0) return;
        if (sum == 0) {
            list.add(new ArrayList<>(tmp));
        }
        for(int i = start ;i<a.length;i++){
            tmp.add(a[i]);
            combinationSum_DFS(a,i,sum-a[i],tmp);
            tmp.remove(tmp.size()-1);
        }
    }

}
