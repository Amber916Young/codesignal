package Tree;

/**
 * @ClassName:restoreBinaryTree
 * @Auther: yyj
 * @Description:
 * @Date: 19/10/2022 10:54
 * @Version: v1.0
 */
public class restoreBinaryTree {


    /***
     *     1
     *    / \
     *   2   3
     *  /   / \
     * 4   5   6
     *
     *
     * */
    //
    Tree<Integer> solution(int[] inorder, int[] preorder) {

        return restoreBinaryTree_DFS(0,0,inorder.length-1,inorder,preorder);
    }

    Tree<Integer> restoreBinaryTree_DFS(int preIndex,int inStart,int inEnd,int[] inorder, int[] preorder){
        if(preIndex >= preorder.length || inStart> inEnd) return null;
        Tree<Integer> node = new Tree(preorder[preIndex]);
        int IND = 0;
        for(int i = inStart; i<=inEnd;i++){
            if(node.value == inorder[i]) {
                IND = i;
                break;
            }
        }

        node.left = restoreBinaryTree_DFS(preIndex+1,inStart,IND-1,inorder,preorder);
        node.right = restoreBinaryTree_DFS(preIndex+IND-inStart+1,IND+1,inEnd,inorder,preorder);

        return node;
    }


}
