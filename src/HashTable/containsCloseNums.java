package HashTable;

import java.util.HashMap;

/**
 * @ClassName:containsCloseNums
 * @Auther: yyj
 * @Description:
 * @Date: 17/10/2022 22:24
 * @Version: v1.0
 */

public class containsCloseNums {
    public static void main(String[] args) {
        solution(new int[]{0, 1, 2, 3, 5, 2},2);
    }
   static boolean solution(int[] nums, int k) {
        if(nums.length == 0)  return false;
        HashMap<Integer,int[]> map = new HashMap<>();
        boolean isVisited = false;
        for(int i =0;i<nums.length;i++){
            int cur = nums[i];
            if(map.containsKey(cur)){
                int[] pair = map.get(cur);
                int index = pair[0];
                int dis = pair[1];
                dis = Math.min(Math.abs(i - index) , dis);
                map.put(cur, new int[]{i,dis});

            }else{
                map.put(cur, new int[]{i,Integer.MAX_VALUE});
            }
        }
        for(int key: map.keySet()){
            int[] cur = map.get(key);
            int dis = cur[1];
            if(dis != Integer.MAX_VALUE){
                if(dis>k) return false;
                isVisited = true;
            }
        }
        return isVisited;
    }

}
