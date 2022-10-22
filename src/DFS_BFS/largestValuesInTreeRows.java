package DFS_BFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName:largestValuesInTreeRows
 * @Auther: yyj
 * @Description:
 * @Date: 22/10/2022 11:15
 * @Version: v1.0
 */
public class largestValuesInTreeRows {
    int[] solution(Tree<Integer> t) {
        if (t == null) return new int[]{};
        List<Integer> res = new ArrayList<>();
        Deque<Tree<Integer>> deque = new ArrayDeque<>();
        deque.add(t);
        while (!deque.isEmpty()) {
            int size = deque.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                Tree<Integer> curr = deque.pop();
                max = Math.max(curr.value, max);
                if (curr.left != null) {
                    deque.add(curr.left);
                }
                if (curr.right != null) {
                    deque.add(curr.right);
                }
            }
            res.add(max);

        }

        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

}
