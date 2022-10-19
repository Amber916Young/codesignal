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


    Tree<Integer> Inoder_Post(int[] inorder, int[] postorder) {
        int len = inorder.length;
        if(len == 0) return null;
        return Inoder_Post_DFS(inorder,0,len,postorder,0,len);
    }

    private Tree<Integer> Inoder_Post_DFS(int[] inorder, int inStart, int inEnd, int[] postorder,
                                          int postStart, int postEnd) {
        if(inStart > inEnd || postStart> postEnd) return null;
        Tree<Integer> node = new Tree(postorder[postEnd-1]);
        int IND = 0;
        for(int i = inStart; i<=inEnd;i++){
            if(node.value == inorder[i]) {
                IND = i;
                break;
            }
        }
        int diff = IND-inStart;
        node.left = Inoder_Post_DFS(inorder,inStart,inStart+diff,postorder,postStart,postStart+diff);
        node.right = Inoder_Post_DFS(inorder,inStart+diff+1,inEnd,postorder,postStart+diff,postEnd-1);
        return node;
    }


}
