package Heaps_Stacks_queues;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @ClassName:kthLargestElement
 * @Auther: yyj
 * @Description:
 * @Date: 19/10/2022 20:46
 * @Version: v1.0
 */
public class kthLargestElement {
    public static void main(String[] args) {
        kthLargestElement largestElement = new kthLargestElement();
        largestElement.solution(new int[]{7, 6, 5, 4, 3, 2, 1},2);
    }

    int solution(int[] nums, int k) {
//        Arrays.sort(nums);
//        return nums[k];
        PriorityQueue<Integer> minQueue = new PriorityQueue<Integer>(k);
        for(int i = 0; i< nums.length; i++){
            minQueue.offer(nums[i]);
            if(minQueue.size() > k){
                minQueue.poll();
            }
        }

        return minQueue.peek();
    }

}
