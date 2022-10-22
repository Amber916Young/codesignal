package DFS_BFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName:traverseTree
 * @Auther: yyj
 * @Description:
 * @Date: 22/10/2022 11:03
 * @Version: v1.0
 */

 class Tree<T> {
   Tree(T x) {
     value = x;
   }
   T value;
   Tree<T> left;
   Tree<T> right;
 }

public class traverseTree {



    /*
     * For
     * t = {
     *     "value": 1,
     *     "left": {
     *         "value": 2,
     *         "left": null,
     *         "right": {
     *             "value": 3,
     *             "left": null,
     *             "right": null
     *         }
     *     },
     *     "right": {
     *         "value": 4,
     *         "left": {
     *             "value": 5,
     *             "left": null,
     *             "right": null
     *         },
     *         "right": null
     *     }
     * }
     * the output should be
     * solution(t) = [1, 2, 4, 3, 5].
     *
     * This t looks like this:
     *
     *      1
     *    /   \
     *   2     4
     *    \   /
     *     3 5
     *
     * */

    public static void main(String[] args) {
        traverseTree test = new traverseTree();
        Tree<Integer> node = new Tree<>(1);
        node.left =  new Tree<>(2);
        node.right =  new Tree<>(4);
        node.left.right =  new Tree<>(3);
        node.right.left =  new Tree<>(5);
        test.solution(node);
    }
    // layer search
    int[] solution(Tree<Integer> t) {
        if(t == null) return new int[]{};
        List<Integer> res = new ArrayList<>();
        Deque<Tree<Integer>> deque = new ArrayDeque<>();
        deque.add(t);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                Tree<Integer> curr = deque.pop();
                res.add(curr.value);
                if(curr.left != null){
                    deque.add(curr.left);
                }
                if(curr.right != null){
                    deque.add(curr.right);
                }
            }
        }

        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

}
