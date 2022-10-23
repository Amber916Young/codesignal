package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName:climbingStaircase
 * @Auther: yyj
 * @Description:
 * @Date: 23/10/2022 14:58
 * @Version: v1.0
 */
public class climbingStaircase {


    /**
     *
     * similar leetcode question
     * 70. Climbing Stairs
     * https://leetcode.com/problems/climbing-stairs/
     *
     * */


    List< List<Integer>> list = new ArrayList<>();

    int[][] solution(int n, int k) {
        List<Integer> res = new ArrayList<>();
        climbingStaircase_DFS(n,k, res);
        int[][] ans = new int[list.size()][];
        for (int i =0;i<list.size();i++){
            ans[i] = list.get(i).stream().mapToInt(Integer::intValue).toArray();
        }
        return ans;
    }

    private void climbingStaircase_DFS(int n, int k, List<Integer> res) {
        if(n == 0){
            list.add(new ArrayList<Integer>(res));
        }
        else{
            for(int i = 1; i <= k; i++){
                if(i <= n){
                    res.add(i);
                    climbingStaircase_DFS(n-i, k, res);
                    res.remove(res.size()-1);
                }
            }
        }
    }


}
