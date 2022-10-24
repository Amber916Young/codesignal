package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:sumSubsets
 * @Author: yyj
 * @Description:
 * @Date: 23/10/2022 16:19
 * @Version: v1.0
 */
public class sumSubsets {



    /**
     *
     * For arr = [1, 2, 3, 4, 5] and num = 5, the output should be
     * solution(arr, num) = [[1, 4], [2, 3], [5]].
     *
     * */
    List<List<Integer>> ansList = new ArrayList<>();
    int[][] solution(int[] arr, int num) {
        List<Integer> list = new ArrayList<>();
        sumSubsets_DFS(arr,num,list,0);
        int[][] ans = new int[ansList.size()][];
        for (int i =0;i<ansList.size();i++){
            ans[i] = ansList.get(i).stream().mapToInt(Integer::intValue).toArray();
        }
        return ans;
    }

    private void sumSubsets_DFS(int[] arr, int num, List<Integer> list,int next) {
        if(num < 0) return;
        if(num == 0){
            ansList.add(new ArrayList<>(list));
            return;
        }

        for(int i = next;i< arr.length;i++) {
            if (i > next && arr[i] == arr[i - 1]) continue; // 去重
            list.add(arr[i]);
            sumSubsets_DFS(arr, num - arr[i], list, i + 1);
            list.remove(list.size() - 1);

        }
    }

}
