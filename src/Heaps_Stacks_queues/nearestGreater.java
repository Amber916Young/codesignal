package Heaps_Stacks_queues;

import java.util.Stack;

/**
 * @ClassName:nearestGreater
 * @Auther: yyj
 * @Description:
 * @Date: 23/10/2022 10:44
 * @Version: v1.0
 */
public class nearestGreater {

    /**
     *
     * For a = [1, 4, 2, 1, 7, 6], the output should be
     * solution(a) = [1, 4, 1, 2, -1, 4].
     *
     * for a[0], the nearest larger element is 4 at index a[1] -> b[0] contains the value 1.
     * for a[1], the nearest larger element is 7 at a[4] -> b[1] contains the value 4.
     * for a[2], the nearest larger element is 4 at a[1] (7 is also larger, but 4 has the minimal position) -> b[2] contains the value 1.
     * for a[3], the nearest larger element is 2 at a[2] (7 is also larger, but 2 has the minimal position) -> b[3] contains the value 2.
     * for a[4], there is no element larger than 7 -> b[4] contains the value -1.
     * for a[5], the nearest larger element is 7 at a[4] -> b[5] contains the value 4.
     *
     * **/

    int[] solution(int[] a) {
        int[] ans = new int[a.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < a.length; i++) {
            int cur = a[i];
            while (!stack.isEmpty() && a[stack.peek()] < cur) {
                int prevDay = stack.pop();
                ans[prevDay] = i-prevDay;
            }
            stack.push(i);
        }

        return ans;

    }



}
