package Tree;

/**
 * @ClassName:isTreeSymmetric
 * @Auther: yyj
 * @Description:
 * @Date: 18/10/2022 17:46
 * @Version: v1.0
 */

public class isTreeSymmetric {
    class Tree<T> {
        Tree(T x) {
            value = x;
        }
        T value;
        Tree<T> left;
        Tree<T> right;
    }
    /*
    * Given a binary tree t,
    * determine whether it is symmetric around its center,
    * i.e. each side mirrors the other.
    *
    **/
    boolean solution(Tree<Integer> t) {
        if (t == null ) return false;
        return isTreeSymmetric_DFS(t.left ,t.right);
    }

    private boolean isTreeSymmetric_DFS(Tree<Integer> left, Tree<Integer> right) {
        if(left == null && right == null) return true;
        if((left == null && right != null) || left != null && right == null) return false;
        if(!left.value.equals(right.value)) return false;
        return  isTreeSymmetric_DFS(left.right,right.left) &&
                isTreeSymmetric_DFS(left.left,right.right);
    }

}
