package Tree;

/**
 * @ClassName:isSubtree
 * @Auther: yyj
 * @Description:
 * @Date: 19/10/2022 00:14
 * @Version: v1.0
 */
public class isSubtree {


    /**
     * t1:            t2:
     * 5             10
     * /   \          /  \
     * 10     7        4    6
     * /    \           / \    \
     * 4     6          1   2   -1
     * / \   /
     * 1   2 -1
     * the output should be solution(t1, t2) = false.
     */

    boolean solution(Tree<Integer> t1, Tree<Integer> t2) {
        if (t1 == null) return false;
        if (isSubtree_DFS(t1, t2)) return true;
        return solution(t1.left, t2) || solution(t1.right, t2);

    }

    private boolean isSubtree_DFS(Tree<Integer> treeF, Tree<Integer> subTree) {
        if (treeF == null || subTree == null) {
            return treeF==null && subTree==null;
        }

        return (treeF.value.equals(subTree.value)) &&
                isSubtree_DFS(treeF.left, subTree.left) &&
                isSubtree_DFS(treeF.right, subTree.right);
    }

}
