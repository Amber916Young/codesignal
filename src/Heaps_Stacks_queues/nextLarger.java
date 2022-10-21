package Heaps_Stacks_queues;

import java.util.Stack;

/**
 * @ClassName:nextLarger
 * @Auther: yyj
 * @Description:
 * @Date: 21/10/2022 12:01
 * @Version: v1.0
 */
public class nextLarger {

    public static void main(String[] args) {
        nextLarger test = new nextLarger();
        test.solution(new int[]{6, 7, 3, 8});
    }

    int[] solution(int[] a) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[a.length];
        for(int i =0; i<a.length;i++){
            if(stack.isEmpty()) {
                stack.push(i);
                continue;
            }
            int cur = a[i];
            while (!stack.isEmpty() && a[stack.peek()] < cur){
                ans[stack.pop()] = cur;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            ans[stack.pop()] = -1;
        }
        return ans;
    }

}
