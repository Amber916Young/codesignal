package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:kthSmallestInBST
 * @Auther: yyj
 * @Description:
 * @Date: 19/10/2022 00:04
 * @Version: v1.0
 */
public class kthSmallestInBST {
    class Tree<T> {
        Tree(T x) {
            value = x;
        }

        T value;
        Tree<T> left;
        Tree<T> right;
    }

    /**
     *
     * Note: Your solution should have only one BST traversal and O(1) extra space complexity,
     * since this is what you will be asked to accomplish in an interview.
     *
     * A tree is considered a binary search tree (BST) if for each of its nodes the following is true:
     *
     * The left subtree of a node contains only nodes with keys less than the node's key.
     * The right subtree of a node contains only nodes with keys greater than the node's key.
     * Both the left and the right subtrees must also be binary search trees.
     * Given a binary search tree t, find the kth smallest element in it.
     *
     * Note that kth smallest element means kth element in increasing order.
     * See examples for better understanding.
     *
     *
     *
     * k = 4, the output should be
     * solution(t, k) = 5.
     *    3
     *  /   \
     * 1     5
     *      / \
     *     4   6
     * **/

    List<Integer> ans;
    int solution(Tree<Integer> t, int k) {
        ans = new ArrayList<>();
        kthSmallestInBST_DFS(t);
        return ans.get(k-1);
    }

    private void kthSmallestInBST_DFS(Tree<Integer> root) {
        if(root == null) return;
        kthSmallestInBST_DFS(root.left);
        ans.add(root.value);
        kthSmallestInBST_DFS(root.right);
    }

}
