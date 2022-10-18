package Tree;

/**
 * @ClassName:hasPathWithGivenSum
 * @Auther: yyj
 * @Description:
 * @Date: 18/10/2022 17:27
 * @Version: v1.0
 */

//
// Binary trees are already defined with this interface:
 class Tree<T> {
   Tree(T x) {
     value = x;
   }
   T value;
   Tree<T> left;
   Tree<T> right;
 }
public class hasPathWithGivenSum {
    public static void main(String[] args) {
        Tree<Integer> t = new Tree<Integer>(8);
        t.right = new Tree<Integer>(3);
        solution(t,8);
    }
   static boolean solution(Tree<Integer> t, int s) {
        if (t.right == null && t.left == null && s == t.value){
            return true;
        }
       if (t.right == null && t.left == null && s != t.value){
           return false;
       }
       return  hasPathWithGivenSum_DFS(t,s,0);
    }

    private static boolean hasPathWithGivenSum_DFS(Tree<Integer> root, int target, int depth) {
        if(root == null){
            if(depth != 1 && target == 0)  return true;
            return false;
        }
        return hasPathWithGivenSum_DFS(root.left,target- root.value,depth+1) ||  hasPathWithGivenSum_DFS(root.right,target- root.value,depth+1);
    }
}
